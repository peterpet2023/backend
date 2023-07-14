package com.example.peterpet.dto;

import com.example.peterpet.domain.Repair;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@ToString
public class RepairReq {

    @ApiModel(value = "Repair update 객체") //dto 객체를 설명할때 사용하는 어노테이션 (swagger)
    @ToString
    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class updateRepairReq{

        private Long repairCode;
        private String repairName;
        private String repairAdd;
        private String repairPhone;


        public Repair toEntity(){
            return Repair.builder().repairCode(repairCode).repairName(repairName)
                    .repairAdd(repairAdd).repairPhone(repairPhone).build();
        };
    }


}
