package com.ttn.springcloud.coupenservice.controllers;

import com.ttn.springcloud.coupenservice.model.Coupon;
import com.ttn.springcloud.coupenservice.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
@CrossOrigin
public class CouponRestController {

	@Autowired
	CouponRepo repo;

//	@GetMapping("/")
//	public String homePage()
//	{
//		return "Welcome to coupon home page";
//	}

	@PostMapping("/coupons")
	public Coupon create(@RequestBody Coupon coupon) {

		return repo.save(coupon);

	}

	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);

	}
}
