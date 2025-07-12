package com.pm.ecommerceapiintegration.services;

import com.pm.ecommerceapiintegration.APIgateway.IProductGateway;
import com.pm.ecommerceapiintegration.dto.ProductDto;
import com.pm.ecommerceapiintegration.dto.ProductWithCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ProductDto> getProductByMatch(String keyword) throws Exception {
        return null;
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception {
        return null;
    }


}
