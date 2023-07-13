package com.example.peterpet.design.service;

import com.example.peterpet.design.repository.DesignRepository;
import com.example.peterpet.dto.DesignReq;
import com.example.peterpet.dto.DesignRes;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DesignService {

    private final DesignRepository designRepository;
    private final ModelMapper modelMapper;

    //전체 디자인 조회
    public DesignRes.selectAllDesign selectAllDesign() {
        List<DesignRes.selectOneDesign> designList = designRepository.findAll()
                .stream()
                .map(member -> modelMapper.map(member,DesignRes.selectOneDesign.class))
                .collect(Collectors.toList());

        DesignRes.selectAllDesign result = new DesignRes.selectAllDesign(designList);

        return result;
    }

    public DesignRes.selectOneDesign selectOneDesignByDesignTitle(String designTitle) {
        DesignRes.selectOneDesign result = modelMapper.map(designRepository.findByDesignTitle(designTitle),DesignRes.selectOneDesign.class);
        return result;
    }

    public void insertDesign(DesignReq.insertDesignReq info) {
        designRepository.save(info.toEntity());
    }

    public void deleteDesignByDesignCode(Long designCode) {
        designRepository.deleteByDesignCode(designCode);
    }

}
