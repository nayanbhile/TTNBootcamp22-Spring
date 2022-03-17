package com.ttn.springcloud.productservice.repos;

import com.ttn.springcloud.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
