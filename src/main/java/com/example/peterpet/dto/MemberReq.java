package com.example.peterpet.dto;

import com.example.peterpet.domain.Member;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@ToString
public class MemberReq {

    @ApiModel(value = "member insert 객체") //dto 객체를 설명할때 사용하는 어노테이션 (swagger)
    @ToString
    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class insertMemberReq{

        @ApiModelProperty(name="회원코드",example="1")
        private Long memberCode;
        @ApiModelProperty(name="회원타입",example="designer")
        private String memberType;
        @ApiModelProperty(name="회원아이디",example="ckdydwns")
        private String memberId;
        @ApiModelProperty(name="회원비밀번호",example="qwer1234!")
        private String memberPw;
        @ApiModelProperty(name="회원이름",example="차용준")
        private String memberName;
        @ApiModelProperty(name="회원전화번호",example="010-9918-5781")
        private String memberPhone;
        @ApiModelProperty(name="회원주소",example="인천광역시 경원대로 717")
        private String memberAdd;

        public Member toEntity(){
            return Member.builder().memberCode(memberCode).memberType(memberType).memberId(memberId).memberPw(memberPw).memberName(memberName)
                    .memberPhone(memberPhone).memberAdd(memberAdd).build();
        };
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    @ToString
    public static class deleteMemberReq{
        private String memberId;
    }

}
