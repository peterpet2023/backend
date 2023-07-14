package com.example.peterpet.repair.service;

import com.example.peterpet.dto.*;
import com.example.peterpet.order.repository.OrderRepository;
import com.example.peterpet.repair.repository.RepairRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.modelmapper.Converters.Collection.map;

@Service
@RequiredArgsConstructor
public class RepairService {

    private final RepairRepository repairRepository;
    private final ModelMapper modelMapper;

    //전체 수선집 조회
    public RepairRes.selectAllRepairRes selectAllRepair() {
        List<RepairRes.selectOneRepairRes> orderList = repairRepository.findAll()
                .stream()
                .map(repair -> modelMapper.map(repair,RepairRes.selectOneRepairRes.class))
                .collect(Collectors.toList());

        RepairRes.selectAllRepairRes result = new RepairRes.selectAllRepairRes(orderList);
        return result;
    }

    //회원코드로 주문내역조회
    public RepairRes.selectOneRepairRes selectRepairByRepairCode(Long repairCode) {
        RepairRes.selectOneRepairRes result = modelMapper.map(repairRepository.findByRepairCode(repairCode),RepairRes.selectOneRepairRes.class);

        return result;
    }


    public void updateRepair(RepairReq.updateRepairReq info) {
        repairRepository.save(info.toEntity());
    }
}
