package com.pm.ecommerceapiintegration.mapper;

import com.pm.ecommerceapiintegration.dto.ProductDto;
import com.pm.ecommerceapiintegration.entity.Category;
import com.pm.ecommerceapiintegration.entity.Product;

public class ProductMapper {


    public  static ProductDto toDto(Product product)
    {
        return ProductDto.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .categoryId(product.getCategory().getId())
              //  .category(product.getCategory())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }


    public static Product toEntity(ProductDto dto, Category category)
    {
        return Product.builder()
                .id(dto.getId())
                .image(dto.getImage())
                .color(dto.getColor())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .model(dto.getModel())
                .title(dto.getTitle())
               .category(category)
                .brand(dto.getBrand())
                .popular(dto.isPopular())
                .build();
    }
}
