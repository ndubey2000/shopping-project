package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String couponCode);
    // Add custom query methods if needed
}
