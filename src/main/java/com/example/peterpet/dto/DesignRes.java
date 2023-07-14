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

    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class selectAllDesignRes{
        private List<selectOneDesignRes> selectAllDesign;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class selectOneDesignRes{
        private Long designCode;
        private String designTitle;
        private String designerName;
        private Date uploadDate;
        private String designImage1;
        private String designImage2;
        private String designImage3;
        private int designCount;
        private String designCategory;
        private int designPrice;
        private int designPriceLower;
        private int designPriceUpper;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class insertDesignRes{
        private Long designCode;
        private String designTitle;
        private String designerName;
        private Date uploadDate;
        private String designImage1;
        private String designImage2;
        private String designImage3;
        private int designCount;
        private String designCategory;
        private int designPrice;
        private int designPriceLower;
        private int designPriceUpper;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public class deleteDesignRes {
        private Long designCode;
        private String designTitle;
        private String designerName;
        private Date uploadDate;
        private String designImage1;
        private String designImage2;
        private String designImage3;
        private int designCount;
        private String designCategory;
        private int designPrice;
        private int designPriceLower;
        private int designPriceUpper;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public class designCountRes {
        private Long designCode;
        private String designTitle;
        private String designerName;
        private Date uploadDate;
        private String designImage1;
        private String designImage2;
        private String designImage3;
        private int designCount;
        private String designCategory;
        private int designPrice;
        private int designPriceLower;
        private int designPriceUpper;
    }
}
