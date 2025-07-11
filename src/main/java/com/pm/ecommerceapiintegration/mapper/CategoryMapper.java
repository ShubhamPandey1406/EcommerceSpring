package com.pm.ecommerceapiintegration.mapper;

import com.pm.ecommerceapiintegration.dto.CategoryDTO;
import com.pm.ecommerceapiintegration.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .name(category.getName())
                .build();
    }

    public static Category toCategory(CategoryDTO categoryDTO) {
        return Category.builder().name(categoryDTO.getName()).build();
    }
}
