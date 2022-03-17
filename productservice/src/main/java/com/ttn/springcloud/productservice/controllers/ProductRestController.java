package com.ttn.springcloud.productservice.controllers;

import com.ttn.springcloud.productservice.dto.Coupon;
import com.ttn.springcloud.productservice.model.Product;
import com.ttn.springcloud.productservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.plaf.IconUIResource;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Autowired
	private ProductRepo repo;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${couponService.url}")
	private String couponServiceURL;

	@PostMapping(value = "/products")
	public Product create(@RequestBody Product product) {

		Coupon coupon = restTemplate.getForObject(couponServiceURL+ product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);

	}

}
