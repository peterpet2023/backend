package com.example.peterpet.order.controller;

import com.example.peterpet.base.BaseResponse;
import com.example.peterpet.dto.MemberRes;
import com.example.peterpet.dto.OrderRes;
import com.example.peterpet.order.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name ="order", description = "order CRUD")
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    //주문 내역 전체 조회
    @ApiOperation(value="order table 전체 조회API", notes ="모든 주문 정보를 조회 할 경우 사용")
    @Tag(name="order")
    @GetMapping("/select")
    public BaseResponse<OrderRes.selectAllOrderRes> selectAllOrder(){
        OrderRes.selectAllOrderRes result = orderService.selectAllOrder();
        return BaseResponse.ok(HttpStatus.OK,"주문 전체 조회 성공", result);
    }

    //내가 주문한 내역 조회(memberCode)로 조회
//    @ApiOperation(value="회원코드로 주문내역 조회API", notes ="회원code로 해당 고객의 주문내역을 조회할 수 있음")
//    @Tag(name="order")
//    @GetMapping("/select/{memberCode}")
//    public BaseResponse<OrderRes.selectAllOrderRes> selectOrderByMemberCode(@PathVariable Long memberCode){
//        OrderRes.selectAllOrderRes result = orderService.selectOrderByMemberCode(memberCode);
//        return  BaseResponse.ok(HttpStatus.OK,"회원Code로 주문내역 조회 성공", result);
//    }

}
