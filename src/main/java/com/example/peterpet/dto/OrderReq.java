package com.example.peterpet.dto;

import com.example.peterpet.domain.Order;
import lombok.*;

import javax.persistence.Column;

@Getter@Setter
@NoArgsConstructor
@ToString
public class OrderReq {

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    @ToString
    public static class selectAllOrderReq{

        private Long orderCode;
        private int orderMemberCode;
        private int orderDesignCode;
        private int orderRepairCode;
        private String orderClothesImage;
        private String orderContents;
        private String orderSize;

        public Order toEntity(){
            return Order.builder().orderCode(orderCode).orderMemberCode(orderMemberCode)
                    .orderDesignCode(orderDesignCode).orderRepairCode(orderRepairCode)
                    .orderClothesImage(orderClothesImage).orderContents(orderContents)
                    .orderSize(orderSize).build();
        }
    }


}
