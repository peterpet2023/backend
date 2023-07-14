package com.example.peterpet.order.service;

import com.example.peterpet.dto.MemberRes;
import com.example.peterpet.dto.OrderReq;
import com.example.peterpet.dto.OrderRes;
import com.example.peterpet.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderRes.selectAllOrderRes selectAllOrder() {

        List<OrderRes.selectOneOrderRes> orderList = orderRepository.findAll()
                .stream()
                .map(order-> modelMapper.map(order,OrderRes.selectOneOrderRes.class))
                .collect(Collectors.toList());

        OrderRes.selectAllOrderRes result = new OrderRes.selectAllOrderRes(orderList);
        return result;
    }

}
