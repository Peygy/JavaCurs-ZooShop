package com.zooshop.repository;

import com.zooshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    Product getProductsByTitle(String name);
}
