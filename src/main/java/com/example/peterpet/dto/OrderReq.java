package com.example.peterpet.dto;

import com.example.peterpet.domain.Member;
import com.example.peterpet.domain.Order;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@ToString
public class OrderReq {

    @ApiModel(value = "order update 객체") //dto 객체를 설명할때 사용하는 어노테이션 (swagger)
    @ToString
    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class updateOrderReq{

        @ApiModelProperty(name="주문코드",example="1")
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
        };
    }


}
