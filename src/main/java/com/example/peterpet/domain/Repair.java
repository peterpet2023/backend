package com.example.peterpet.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor
@Table(name="REPAIR_TBL")
@ToString
@Builder
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repairCode;
    @Column
    private String repairName;
    @Column
    private String repairAdd;
    @Column
    private String repairPhone;

}
