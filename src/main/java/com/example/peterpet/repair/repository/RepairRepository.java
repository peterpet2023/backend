package com.example.peterpet.repair.repository;

import com.example.peterpet.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RepairRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByOrderMemberCode(int orderMemberCode);
}
