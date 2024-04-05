package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Coupon;
import com.project.repositories.CouponRepository;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public Coupon getCouponByCode(String couponCode) {
        return couponRepository.findByCode(couponCode);
    }

    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

	public List<Coupon> getAllCoupons() {

		return couponRepository.findAll();
	}

    // Other coupon-related methods
}
