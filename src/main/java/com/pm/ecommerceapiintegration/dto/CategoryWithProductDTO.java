package com.pm.ecommerceapiintegration.dto;


import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryWithProductDTO {
    private Long id;
    private String name;
    private List<ProductDto> products;
}
