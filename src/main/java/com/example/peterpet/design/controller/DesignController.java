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
    @Tag(name="design")
    @GetMapping("/select")
    public BaseResponse<DesignRes.selectAllDesignRes> selectAllMember(){
        DesignRes.selectAllDesignRes result = designService.selectAllDesign();
        return BaseResponse.ok(HttpStatus.OK,"전체 디자인 조회 성공", result);
    }

    //디자인 제목으로 조회 (검색)
    @ApiOperation(value="디자인제목으로 조회API", notes ="디자인 제목으로 디자인을 조회할 수 있다.")
    @Tag(name="design")
    @GetMapping("/select/designTitle/{designTitle}")
    public BaseResponse<DesignRes.selectAllDesignRes> selectOneDesignByDesignTitle(@PathVariable String designTitle){
        String likeDesignTitle = "%"+designTitle+"%";
        DesignRes.selectAllDesignRes result = designService.selectAllDesignByDesignTitle(likeDesignTitle);
        return  BaseResponse.ok(HttpStatus.OK,"디자인제목으로 조회 성공", result);
    }

    //디자인 카테고리로 조회(검색)
    @ApiOperation(value="디자인카테고리로 조회API", notes ="디자인의 카테고리로 디자인을 조회할 수 있다.")
    @Tag(name="design")
    @GetMapping("/select/designCategory/{designCategory}")
    public BaseResponse<DesignRes.selectAllDesignRes> selectAllDesignByDesignCategory(@PathVariable String designCategory){
        String likeDesignCategory = "%" + designCategory + "%";
        DesignRes.selectAllDesignRes result = designService.selectAllDesignByDesignCategory(likeDesignCategory);
        return  BaseResponse.ok(HttpStatus.OK,"디자인카테고리로 조회 성공", result);
    }

    //디자인 가격으로 조회(가격 범위 선택)
    @ApiOperation(value="디자인가격으로 조회API", notes ="디자인의 가격으로 디자인을 조회할 수 있다.")
    @Tag(name="design")
    @GetMapping("/select/designPrice/{designPriceLower}/{designPriceUpper}")
    public BaseResponse<DesignRes.selectAllDesignRes> selectAllDesignByDesignPrice(@PathVariable int designPriceLower,@PathVariable int designPriceUpper){
        DesignRes.selectAllDesignRes result = designService.selectAllDesignByDesignPrice(designPriceLower, designPriceUpper);
        return  BaseResponse.ok(HttpStatus.OK,"디자인가격으로 조회 성공", result);
    }


    //디자인 insert, update
    @ApiOperation(value="디자인 업데이트API", notes ="디자인을 등록하거나 이미 업로드된 디자인 게시물을 수정할 수 있다.")
    @Tag(name="design")
    @PostMapping("/update")
    public BaseResponse<DesignRes.insertDesignRes> insertDesign(@RequestBody DesignReq.insertDesignReq info){
        System.out.println("controller insert info : " + info);
        designService.insertDesign(info);
        return BaseResponse.ok(HttpStatus.OK, "디자인 정보 입력 성공");
    }

    //디자인 delete
    @ApiOperation(value="디자인 삭제API", notes ="삭제하고 싶은 디자인의 디자인코드를 URL로 전달하면 삭제할 수 있다.")
    @Tag(name="design")
    @DeleteMapping("/delete/{designCode}")
    public BaseResponse<DesignRes.deleteDesignRes> deleteDesignByDesignCode(@PathVariable Long designCode){
        designService.deleteDesignByDesignCode(designCode);
        return BaseResponse.ok(HttpStatus.OK,"디자인코드로 삭제 성공");
    }

    //사용 횟수 증가
    @ApiOperation(value="디자인 사용횟수 증가API", notes ="디자인이 사용되었을 때 count증가시키기 위해 사용될 수 있다.")
    @Tag(name="design")
    @PostMapping("/count/{designCode}")
    public BaseResponse<DesignRes.designCountRes> designCount(@PathVariable Long designCode) throws Exception {
        designService.designCount(designCode);
        return BaseResponse.ok(HttpStatus.OK, "디자인 사용 횟수 증가 성공");
    }

}
