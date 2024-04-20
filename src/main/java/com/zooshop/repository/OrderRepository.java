package com.zooshop.repository;

import com.zooshop.entity.Order;
import com.zooshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer>
{

}
