package com.example.peterpet.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "ORDER_TBL")
@Builder
@ToString
@NoArgsConstructor @AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCode;
    @Column
    private int orderMemberCode;
    @Column
    private int orderDesignCode;
    @Column
    private int orderRepairCode;
    @Column
    private String orderClothesImage;
    @Column
    private String orderContents;
    @Column
    private String orderSize;
}
