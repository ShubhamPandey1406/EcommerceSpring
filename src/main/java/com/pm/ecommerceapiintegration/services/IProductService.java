package com.pm.ecommerceapiintegration.services;

import com.pm.ecommerceapiintegration.dto.ProductDto;

public interface IProductService {

    ProductDto getProductById(Long id) throws Exception;
}
