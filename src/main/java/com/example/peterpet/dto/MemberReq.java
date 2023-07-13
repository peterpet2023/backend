package com.example.peterpet.dto;

import com.example.peterpet.domain.Member;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@ToString
public class MemberReq {

    @ToString
    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class insertMemberReq{
        private Long memberCode;
        private String memberType;
        private String memberId;
        private String memberPw;
        private String memberName;
        private String memberPhone;
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
