package com.pm.ecommerceapiintegration.mapper;

import com.pm.ecommerceapiintegration.dto.CategoryDTO;
import com.pm.ecommerceapiintegration.dto.FakeStoreCategoryResponseDTO;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetAllCategoriesMapper {

    public static FakeStoreCategoryResponseDTO toFakeStoreCategoryDTO()
    {
        return null;
    }

    public static List<CategoryDTO> toCategoryDto(FakeStoreCategoryResponseDTO dto)
    {
        return dto.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                .build()).toList();
    }




}
