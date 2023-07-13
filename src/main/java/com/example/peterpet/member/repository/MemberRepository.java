package com.example.peterpet.member.repository;

import com.example.peterpet.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface MemberRepository extends JpaRepository<Member, Long> {


    Member findByMemberCode(Long memberCode);

    @Transactional
    void deleteByMemberId(String memberId);
}
