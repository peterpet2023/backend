package com.example.peterpet.repair.service;

import com.example.peterpet.dto.OrderReq;
import com.example.peterpet.dto.OrderRes;
import com.example.peterpet.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepairService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    //전체 디자인 조회
    public OrderRes.selectAllOrderRes selectAllOrder() {
        List<OrderRes.selectOneOrderRes> orderList = orderRepository.findAll()
                .stream()
                .map(order -> modelMapper.map(order,OrderRes.selectOneOrderRes.class))
                .collect(Collectors.toList());

        OrderRes.selectAllOrderRes result = new OrderRes.selectAllOrderRes(orderList);
        return result;
    }

    //회원코드로 주문내역조회
    public OrderRes.selectAllOrderRes selectOrderByMemberCode(int orderMemberCode) {
        List<OrderRes.selectOneOrderRes> resultList = orderRepository.findAllByOrderMemberCode(orderMemberCode)
                .stream()
                .map(order-> modelMapper.map(order, OrderRes.selectOneOrderRes.class))
                .collect(Collectors.toList());

        OrderRes.selectAllOrderRes result = new OrderRes.selectAllOrderRes(resultList);

        return result;
    }

//    //카테고리로 조회
//    public DesignRes.selectAllDesignRes selectAllDesignByDesignCategory(String designCategory) {
//        List<DesignRes.selectOneDesignRes> resultList = designRepository.findAllByDesignCategoryLike(designCategory)
//                .stream()
//                .map(design -> modelMapper.map(design, DesignRes.selectOneDesignRes.class))
//                .collect(Collectors.toList());
//        DesignRes.selectAllDesignRes result = new DesignRes.selectAllDesignRes(resultList);
//        return result;
//    }
//
//    public DesignRes.selectAllDesignRes selectAllDesignByDesignPrice(int designPriceLower, int designPriceUpper) {
//        List<DesignRes.selectOneDesignRes> resultList = designRepository.findByDesignPriceBetween(designPriceLower, designPriceUpper)
//                .stream()
//                .map(design -> modelMapper.map(design, DesignRes.selectOneDesignRes.class))
//                .collect(Collectors.toList());
//        DesignRes.selectAllDesignRes result = new DesignRes.selectAllDesignRes(resultList);
//        return result;
//    }

    public void updateOrder(OrderReq.updateOrderReq info) {
        orderRepository.save(info.toEntity());
    }



}
