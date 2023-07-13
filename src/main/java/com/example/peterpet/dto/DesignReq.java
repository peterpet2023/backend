package com.example.peterpet.dto;

import com.example.peterpet.domain.Design;
import com.example.peterpet.domain.Member;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@ToString
public class DesignReq {

    @ApiModel(value = "design insert 객체") //dto 객체를 설명할때 사용하는 어노테이션 (swagger)
    @ToString
    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class insertDesignReq{

        @ApiModelProperty(name="디자인코드",example="1")
        private Long designCode;
        @ApiModelProperty(name="디자인제목",example="슈퍼맨의상")
        private String designTitle;
        @ApiModelProperty(name="디자이너이름",example="탐쿠루주")
        private String designerName;
        @ApiModelProperty(name="업로드날짜",example="2023-07-14")
        private Date uploadDate;
        @ApiModelProperty(name="이미지1",example="url..")
        private String designImage1;
        @ApiModelProperty(name="이미지2",example="url..")
        private String designImage2;
        @ApiModelProperty(name="이미지3",example="url..")
        private String designImage3;
        @ApiModelProperty(name="사용된횟수",example="50")
        private int designCount;


        public Design toEntity(){
            return Design.builder().designCode(designCode).designTitle(designTitle).designerName(designerName)
                    .uploadDate(uploadDate).designImage1(designImage1).designImage2(designImage2)
                    .designImage3(designImage3).designCount(designCount).build();
        };
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    @ToString
    public static class deleteDesignReq{
        private String desingCode;
    }

}
