package com.example.peterpet.member.service;

import com.example.peterpet.dto.MemberReq;
import com.example.peterpet.dto.MemberRes;
import com.example.peterpet.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    //전체 회원 조회
    public MemberRes.selectAllMember selectAllMember() {
        List<MemberRes.selectOneMember> memberList = memberRepository.findAll()
                .stream()
                .map(member -> modelMapper.map(member,MemberRes.selectOneMember.class))
                .collect(Collectors.toList());

        MemberRes.selectAllMember result = new MemberRes.selectAllMember(memberList);

        return result;
    }

    public MemberRes.selectOneMember selectOneMemberByMemberId(String memberId) {
        MemberRes.selectOneMember result = modelMapper.map(memberRepository.findByMemberId(memberId),MemberRes.selectOneMember.class);
        return result;
    }

    public void insertMember(MemberReq.insertMemberReq info) {
        memberRepository.save(info.toEntity());
    }

    public void deleteMemberByMemberId(String memberId) {
        memberRepository.deleteByMemberId(memberId);
    }
}
