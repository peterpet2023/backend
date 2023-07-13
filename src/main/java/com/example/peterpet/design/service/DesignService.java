package com.example.peterpet.design.service;

import com.example.peterpet.design.repository.DesignRepository;
import com.example.peterpet.domain.Design;
import com.example.peterpet.dto.DesignReq;
import com.example.peterpet.dto.DesignRes;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DesignService {

    private final DesignRepository designRepository;
    private final ModelMapper modelMapper;

    //전체 디자인 조회
    public DesignRes.selectAllDesignRes selectAllDesign() {
        List<DesignRes.selectOneDesignRes> designList = designRepository.findAll()
                .stream()
                .map(member -> modelMapper.map(member,DesignRes.selectOneDesignRes.class))
                .collect(Collectors.toList());

        DesignRes.selectAllDesignRes result = new DesignRes.selectAllDesignRes(designList);

        return result;
    }

    public DesignRes.selectOneDesignRes selectOneDesignByDesignTitle(String designTitle) {
        DesignRes.selectOneDesignRes result = modelMapper.map(designRepository.findByDesignTitle(designTitle),DesignRes.selectOneDesignRes.class);
        return result;
    }

    public void insertDesign(DesignReq.insertDesignReq info) {
        designRepository.save(info.toEntity());
    }

    public void deleteDesignByDesignCode(Long designCode) {
        designRepository.deleteByDesignCode(designCode);
    }

    public void designCount(Long designCode) throws Exception {
        Design designCount = designRepository.findById(designCode).orElseThrow(()->new Exception("해당하는 디자인이 존재하지 않음"));
        designCount.setDesignCount(designCount.getDesignCount()+1);
        designRepository.save(designCount);
    }
}
