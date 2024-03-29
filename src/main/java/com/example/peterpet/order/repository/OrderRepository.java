package com.example.peterpet.order.repository;

import com.example.peterpet.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByOrderMemberCode(int orderMemberCode);
}
