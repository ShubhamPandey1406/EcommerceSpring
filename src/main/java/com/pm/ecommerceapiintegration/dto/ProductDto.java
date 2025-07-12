package com.pm.ecommerceapiintegration.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto{
	private String image;
	private String color;
	private int price;
	private String description;
	private int discount;
	private String model;
	private long id;
	private String title;
	private long categoryId;
	private String brand;
	private boolean popular;
}