package com.example.peterpet.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name="DESIGN_TBL")
@ToString
@Builder
public class Design {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long designCode;
    @Column
    private String designTitle;
    @Column
    private String designerName;
    @Column
    private Date uploadDate;
    @Column
    private String designImage1;
    @Column
    private String designImage2;
    @Column
    private String designImage3;
    @Column
    private int designCount;
    @Column
    private int designPrice;
    @Column
    private String designCategory;


}
