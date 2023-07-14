package com.example.peterpet.order.controller;

import com.example.peterpet.base.BaseResponse;
import com.example.peterpet.dto.OrderRes;
import com.example.peterpet.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/select")
    public BaseResponse<OrderRes.selectAllOrderRes> selectAllOrder(){
        OrderRes.selectAllOrderRes result = orderService.selectAllOrder();
        return BaseResponse.ok(HttpStatus.OK,"주문 전체 조회 성공", result);
    }
}
