package com.ttn.springcloud.coupenservice.repos;

import com.ttn.springcloud.coupenservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
