package com.zooshop.repository;

import com.zooshop.entity.Product;
import com.zooshop.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkshopRepository extends JpaRepository<Workshop, Integer>
{
    Workshop getWorkshopByProduct(Product product);
}
