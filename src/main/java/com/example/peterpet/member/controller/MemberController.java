package com.example.peterpet.member.controller;

import com.example.peterpet.base.BaseResponse;
import com.example.peterpet.dto.MemberReq;
import com.example.peterpet.dto.MemberRes;
import com.example.peterpet.member.service.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name="member", description = "member CRUD")
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ApiResponses({
            @ApiResponse(code=200,message="success"),
            @ApiResponse(code=404,message="Not found")
    })

    //전체 회원 조회
    @ApiOperation(value="member table 전체 조회API", notes ="모든 회원 정보를 조회 할 경우 사용")
    @Tag(name="member")
    @GetMapping("/select")
    public BaseResponse<MemberRes.selectAllMember> selectAllMember(){
        MemberRes.selectAllMember result = memberService.selectAllMember();
        return BaseResponse.ok(HttpStatus.OK,"전체 회원 조회 성공", result);
    }

    @ApiOperation(value="회원코드로 조회API", notes ="특정코드회원 정보를 조회 할 때 url에 code를 포함하여 요청")
    @Tag(name="member")
    @GetMapping("/select/{memberCode}")
    public BaseResponse<MemberRes.selectOneMember> selectOneMemberByMemberCode(@PathVariable Long memberCode){
        MemberRes.selectOneMember result = memberService.selectOneMemberByMemberCode(memberCode);
        System.out.println("controller result : " + result);
        return  BaseResponse.ok(HttpStatus.OK,"회원Code로 조회 성공", result);
    }

    @ApiOperation(value="member 업데이트API", notes ="회원을 insert하고 싶을 때는 모든 정보를 입력/ 수정하고 싶을 때는 회원 code를 포함하여 전달.")
    @Tag(name="member")
    @PostMapping("/update")
    public BaseResponse<MemberRes.insertMember> insertMember(@RequestBody MemberReq.insertMemberReq info){
        System.out.println("controller insert info : " + info);
        memberService.insertMember(info);
        return BaseResponse.ok(HttpStatus.OK, "회원 정보 입력 성공");
    }

    @ApiOperation(value="member 삭제API", notes ="삭제하고 싶은 회원 ID를 url에 담아서 요청")
    @Tag(name="member")
    @DeleteMapping("/delete/{memberId}")
    public BaseResponse<MemberRes.deleteMember> deleteMemberByMemberId(@PathVariable String memberId){
        memberService.deleteMemberByMemberId(memberId);
        return BaseResponse.ok(HttpStatus.OK,"회원ID로 삭제 성공");
    }

}
