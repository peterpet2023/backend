package com.example.peterpet.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class OrderRes {

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class selectOneOrderRes{
        private Long orderCode;
        private int orderMemberCode;
        private int orderDesignCode;
        private int orderRepairCode;
        private String orderClothesImage;
        private String orderContents;
        private String orderSize;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class selectAllOrderRes{
        private List<selectOneOrderRes> selectAllOrderRes;
    }


    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class updateOrderRes {
        private Long orderCode;
        private int orderMemberCode;
        private int orderDesignCode;
        private int orderRepairCode;
        private String orderClothesImage;
        private String orderContents;
        private String orderSize;
    }

}
