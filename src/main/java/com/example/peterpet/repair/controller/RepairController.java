package com.example.peterpet.repair.controller;

import com.example.peterpet.base.BaseResponse;
import com.example.peterpet.dto.OrderReq;
import com.example.peterpet.dto.OrderRes;
import com.example.peterpet.dto.RepairReq;
import com.example.peterpet.dto.RepairRes;
import com.example.peterpet.order.service.OrderService;
import com.example.peterpet.repair.service.RepairService;
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

    private final RepairService repairService;

    //수선집 전체 조회
    @ApiOperation(value="수선집 전체 조회API", notes ="모든 수선집 정보를 조회할 수 있다.")
    @Tag(name="repair")
    @GetMapping("/select")
    public BaseResponse<RepairRes.selectAllRepairRes> selectAllRepair(){
        RepairRes.selectAllRepairRes result = repairService.selectAllRepair();
        return BaseResponse.ok(HttpStatus.OK,"전체 수선집 조회 성공", result);
    }

    //수선집 코드로 수선집 조회
    @ApiOperation(value="수선집코드로 수선집 정보 조회API", notes ="수선집코드로 수선집 정보를 조회할 수 있다.")
    @Tag(name="repair")
    @GetMapping("/select/repairCode/{repairCode}")
    public BaseResponse<RepairRes.selectOneRepairRes> selectRepairByRepairCode(@PathVariable Long repairCode){
        RepairRes.selectOneRepairRes result = repairService.selectRepairByRepairCode(repairCode);
        return  BaseResponse.ok(HttpStatus.OK,"수선집코드로 수선집 조회 성공", result);
    }

    //수선집 insert, update
    @ApiOperation(value="수선집 업데이트API", notes ="수선집 등록 및 수정")
    @Tag(name="repair")
    @PostMapping("/update")
    public BaseResponse<RepairReq.updateRepairReq> updateRepair(@RequestBody RepairReq.updateRepairReq info){
        repairService.updateRepair(info);
        return BaseResponse.ok(HttpStatus.OK, "수선집 업데이트 성공");
    }


}
