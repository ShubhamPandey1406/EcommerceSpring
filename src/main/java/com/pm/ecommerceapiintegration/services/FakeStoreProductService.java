package com.pm.ecommerceapiintegration.services;

import com.pm.ecommerceapiintegration.APIgateway.IProductGateway;
import com.pm.ecommerceapiintegration.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements IProductService{

    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductDto getProductById(Long id) throws Exception {

        return productGateway.getProductById(id);

    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return null;
    }
}
