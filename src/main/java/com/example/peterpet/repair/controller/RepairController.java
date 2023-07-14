package com.example.peterpet.repair.controller;

import com.example.peterpet.base.BaseResponse;
import com.example.peterpet.dto.OrderReq;
import com.example.peterpet.dto.OrderRes;
import com.example.peterpet.order.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name="repair", description = "repair CRUD")
@RestController
@RequestMapping("/repair")
@RequiredArgsConstructor
public class RepairController {

    private final OrderService orderService;

    //수선집 전체 조회
    @ApiOperation(value="수선집 전체 조회API", notes ="모든 수선집 정보를 조회할 수 있다.")
    @Tag(name="repair")
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

//    //디자인 코드로 주문 내역 조회
//    @ApiOperation(value="디자인카테고리로 조회API", notes ="디자인의 카테고리로 디자인을 조회할 수 있다.")
//    @Tag(name="design")
//    @GetMapping("/select/designCategory/{designCategory}")
//    public BaseResponse<DesignRes.selectAllDesignRes> selectAllDesignByDesignCategory(@PathVariable String designCategory){
//        String likeDesignCategory = "%" + designCategory + "%";
//        DesignRes.selectAllDesignRes result = designService.selectAllDesignByDesignCategory(likeDesignCategory);
//        return  BaseResponse.ok(HttpStatus.OK,"디자인카테고리로 조회 성공", result);
//    }
//
//    //디자인 가격으로 조회(가격 범위 선택)
//    @ApiOperation(value="디자인가격으로 조회API", notes ="디자인의 가격으로 디자인을 조회할 수 있다.")
//    @Tag(name="design")
//    @GetMapping("/select/designPrice/{designPriceLower}/{designPriceUpper}")
//    public BaseResponse<DesignRes.selectAllDesignRes> selectAllDesignByDesignPrice(@PathVariable int designPriceLower,@PathVariable int designPriceUpper){
//        DesignRes.selectAllDesignRes result = designService.selectAllDesignByDesignPrice(designPriceLower, designPriceUpper);
//        return  BaseResponse.ok(HttpStatus.OK,"디자인가격으로 조회 성공", result);
//    }

    //주문 insert, update
    @ApiOperation(value="주문 업데이트API", notes ="주문 등록 및 수정")
    @Tag(name="order")
    @PostMapping("/update")
    public BaseResponse<OrderRes.updateOrderRes> updateOrder(@RequestBody OrderReq.updateOrderReq info){
        orderService.updateOrder(info);
        return BaseResponse.ok(HttpStatus.OK, "주문내역 업데이트 성공");
    }

}
