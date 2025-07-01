package com.pm.ecommerceapiintegration.APIgateway;

import com.pm.ecommerceapiintegration.dto.ProductDto;

public interface IProductGateway {
    ProductDto getProductById(Long id) throws Exception;
}
