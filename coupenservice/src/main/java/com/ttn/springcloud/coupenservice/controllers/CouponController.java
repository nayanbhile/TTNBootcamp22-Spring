package com.ttn.springcloud.coupenservice.controllers;


import com.ttn.springcloud.coupenservice.model.Coupon;
import com.ttn.springcloud.coupenservice.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CouponController {

//	@GetMapping("/")
//	public String index()
//	{
//		return "index";
//	}

	@Autowired
	private CouponRepo repo;

	@GetMapping("/showCreateCoupon")
	public String showCreateCoupon() {
		return "createCoupon";
	}

	@PostMapping("/saveCoupon")
	public String save(Coupon coupon) {
		repo.save(coupon);
		return "createResponse";
	}

	@GetMapping("/showGetCoupon")
	public String showGetCoupon() {
		return "getCouponPage";
	}

	@GetMapping("/getCoupon")
	public ModelAndView getCoupon(String code) {
		ModelAndView mav = new ModelAndView("couponDetails");
		mav.addObject(repo.findByCode(code));
		return mav;
	}

}
