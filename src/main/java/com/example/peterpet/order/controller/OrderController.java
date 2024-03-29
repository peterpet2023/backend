package com.example.peterpet.order.controller;

import com.example.peterpet.base.BaseResponse;
import com.example.peterpet.design.service.DesignService;
import com.example.peterpet.dto.DesignReq;
import com.example.peterpet.dto.DesignRes;
import com.example.peterpet.dto.OrderReq;
import com.example.peterpet.dto.OrderRes;
import com.example.peterpet.order.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name="order", description = "order CRUD")
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    //전체 주문 조회
    @ApiOperation(value="주문 전체 조회API", notes ="모든 주문 정보를 조회할 수 있다.")
    @Tag(name="order")
    @GetMapping("/select")
    public BaseResponse<OrderRes.selectAllOrderRes> selectAllOrder(){
        OrderRes.selectAllOrderRes result = orderService.selectAllOrder();
        return BaseResponse.ok(HttpStatus.OK,"전체 주문 조회 성공", result);
    }

    //회원 코드로 내가 주문한 내역 조회
    @ApiOperation(value="회원코드로 내가 주문한 내역 조회API", notes ="회원코드로 내가 주문한 주문을 조회할 수 있다.")
    @Tag(name="order")
    @GetMapping("/select/orderMemberCode/{orderMemberCode}")
    public BaseResponse<OrderRes.selectAllOrderRes> selectOrderByMemberCode(@PathVariable int orderMemberCode){
        OrderRes.selectAllOrderRes result = orderService.selectOrderByMemberCode(orderMemberCode);
        return  BaseResponse.ok(HttpStatus.OK,"회원코드로 주문내역 조회 성공", result);
    }

    //주문 insert, update
    @ApiOperation(value="주문 업데이트API", notes ="주문 등록 및 수정")
    @Tag(name="order")
    @PostMapping("/update")
    public BaseResponse<OrderRes.updateOrderRes> updateOrder(@RequestBody OrderReq.updateOrderReq info){
        orderService.updateOrder(info);
        return BaseResponse.ok(HttpStatus.OK, "주문내역 업데이트 성공");
    }

}
