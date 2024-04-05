package com.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private int quantity;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

	private Long userId;

//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;    
	private String product;

//    @ManyToOne
//    @JoinColumn(name = "coupon_code")
	private String coupon;

//	@OneToOne(mappedBy = "order")
//	private Transaction transaction;

	private Double amount;

	// getters, setters, and other methods to complete
	
	
}
