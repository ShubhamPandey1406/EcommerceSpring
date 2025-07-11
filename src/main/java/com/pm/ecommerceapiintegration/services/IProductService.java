package com.pm.ecommerceapiintegration.services;

import com.pm.ecommerceapiintegration.dto.ProductDto;
import com.pm.ecommerceapiintegration.dto.ProductWithCategoryDTO;

import java.util.List;

public interface IProductService {

    ProductDto getProductById(Long id) throws Exception;

    ProductDto createProduct(ProductDto productDto) throws Exception;

   List<ProductDto> getProductByMatch(String keyword) throws Exception;

   ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception;
}
