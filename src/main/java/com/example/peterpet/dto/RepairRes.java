package com.example.peterpet.dto;

import lombok.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class RepairRes {

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class selectOneRepairRes{
        private Long repairCode;
        private String repairName;
        private String repairAdd;
        private String repairPhone;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class selectAllRepairRes{
        private List<selectOneRepairRes> selectAllRepairRes;
    }

}
