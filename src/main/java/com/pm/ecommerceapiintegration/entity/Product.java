package com.pm.ecommerceapiintegration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {

    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private long id;
    private String title;
   // private String category;
    private String brand;
    private boolean popular;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="category_id",nullable = false)
    private Category category;
}