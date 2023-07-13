package com.example.peterpet.design.controller;

import com.example.peterpet.base.BaseResponse;
import com.example.peterpet.design.service.DesignService;
import com.example.peterpet.dto.DesignReq;
import com.example.peterpet.dto.DesignRes;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name="design", description = "design CRUD")
@RestController
@RequestMapping("/design")
@RequiredArgsConstructor
public class DesignController {

    private final DesignService designService;

    //전체 디자인 조회
    @ApiOperation(value="디자인 전체 조회API", notes ="모든 디자인 정보를 조회할 수 있다.")
    @Tag(name="member")
    @GetMapping("/select")
    public BaseResponse<DesignRes.selectAllDesign> selectAllMember(){
        DesignRes.selectAllDesign result = designService.selectAllDesign();
        return BaseResponse.ok(HttpStatus.OK,"전체 디자인 조회 성공", result);
    }

    //디자인 제목으로 조회 (검색)
    @ApiOperation(value="디자인제목으로 조회API", notes ="디자인 제목으로 디자인을 조회할 수 있다.")
    @Tag(name="member")
    @GetMapping("/select/{designTitle}")
    public BaseResponse<DesignRes.selectOneDesign> selectOneMemberByDesignTitle(@PathVariable String designTitle){
        DesignRes.selectOneDesign result = designService.selectOneDesignByDesignTitle(designTitle);
        System.out.println("controller result : " + result);
        return  BaseResponse.ok(HttpStatus.OK,"회원Code로 조회 성공", result);
    }

    //디자인 insert, update
    @ApiOperation(value="디자인 업데이트API", notes ="디자인을 등록하거나 이미 업로드된 디자인 게시물을 수정할 수 있다.")
    @Tag(name="member")
    @PostMapping("/update")
    public BaseResponse<DesignRes.insertDesign> insertDesing(@RequestBody DesignReq.insertDesignReq info){
        System.out.println("controller insert info : " + info);
        designService.insertDesign(info);
        return BaseResponse.ok(HttpStatus.OK, "회원 정보 입력 성공");
    }

    //디자인 delete
    @ApiOperation(value="디자인 삭제API", notes ="삭제하고 싶은 디자인의 디자인코드를 URL로 전달하면 삭제할 수 있다.")
    @Tag(name="member")
    @DeleteMapping("/delete/{designCode}")
    public BaseResponse<DesignRes.deleteDesign> deleteDesignByDesignCode(@PathVariable Long designCode){
        designService.deleteDesignByDesignCode(designCode);
        return BaseResponse.ok(HttpStatus.OK,"디자인코드로 삭제 성공");
    }

    //merge 확인하기

}
