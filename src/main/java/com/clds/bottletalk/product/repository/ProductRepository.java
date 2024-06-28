package com.clds.bottletalk.product.repository;

import com.clds.bottletalk.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
