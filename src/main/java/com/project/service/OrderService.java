package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Coupon;
import com.project.model.Order;
import com.project.model.OrderRequestDto;
import com.project.model.Product;
import com.project.model.User;
import com.project.repositories.OrderRepository;
import com.project.repositories.ProductRepository;
import com.project.repositories.UserRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired    
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;   
    @Autowired
    private CouponService couponService;	

    public Order createOrder(Long userId, OrderRequestDto orderRequest) {
    	
		User user = userRepository.findById(userId).get();
		Order order = new Order();
		order.setQuantity(orderRequest.getQuantity());
		
		Product product = productRepository.findById(orderRequest.getProductId()).get();
		
//		if(orderRequest.getCouponCode() != null) {
			Coupon couponByCode = couponService.getCouponByCode(orderRequest.getCouponCode());
			System.out.println(user);
			if(couponByCode != null && !user.getCouponUsed().contains(couponByCode.getCode())) {
				order.setCoupon(couponByCode.getCode());
				Double totalAmount = (product.getPrice() * orderRequest.getQuantity()) * (1- (couponByCode.getDiscountPercentage()/100));
				order.setAmount(totalAmount);
			}else {
				Double totalAmount = (product.getPrice() * orderRequest.getQuantity());
				order.setAmount(totalAmount);
			}
//		}
		order.setProduct(product.getName());
		order.setUserId(user.getUserId());
		orderRepository.save(order);
		return order;
    }

	public Order getOrder(Long orderId) {
		return orderRepository.findById(orderId).get();
	}
}
