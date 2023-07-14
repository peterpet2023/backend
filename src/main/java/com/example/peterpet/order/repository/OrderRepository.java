package com.example.peterpet.order.repository;

import com.example.peterpet.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
