package com.example.peterpet.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor
@Table(name="MEMBER_TBL")
@ToString
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberCode;

    @Column
    private String memberType;
    @Column
    private String memberId;
    @Column
    private String memberPw;
    @Column
    private String memberName;
    @Column
    private String memberPhone;
    @Column
    private String memberAdd;

}
