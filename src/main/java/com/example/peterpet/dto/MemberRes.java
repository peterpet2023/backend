package com.example.peterpet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class MemberRes {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class selectAllMember{
        private List<selectOneMember> selectAllMember;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class selectOneMember{
        private Long memberCode;
        private String memberType;
        private String memberId;
        private String memberPw;
        private String memberName;
        private String memberPhone;
        private String memberAdd;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class insertMember{
        private Long memberCode;
        private String memberType;
        private String memberId;
        private String memberPw;
        private String memberName;
        private String memberPhone;
        private String memberAdd;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public class deleteMember {
        private Long memberCode;
        private String memberType;
        private String memberId;
        private String memberPw;
        private String memberName;
        private String memberPhone;
        private String memberAdd;
    }
}
