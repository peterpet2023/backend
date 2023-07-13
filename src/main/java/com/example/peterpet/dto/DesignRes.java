package com.example.peterpet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class DesignRes {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class selectAllDesign{
        private List<selectOneDesign> selectAllDesign;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class selectOneDesign{
        private Long designCode;
        private String designTitle;
        private String designerName;
        private Date uploadDate;
        private String designImage1;
        private String designImage2;
        private String designImage3;
        private int designCount;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class insertDesign{
        private Long designCode;
        private String designTitle;
        private String designerName;
        private Date uploadDate;
        private String designImage1;
        private String designImage2;
        private String designImage3;
        private int designCount;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public class deleteDesign {
        private Long designCode;
        private String designTitle;
        private String designerName;
        private Date uploadDate;
        private String designImage1;
        private String designImage2;
        private String designImage3;
        private int designCount;
    }
}
