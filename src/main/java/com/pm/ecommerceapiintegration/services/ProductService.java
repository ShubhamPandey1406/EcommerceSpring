package com.pm.ecommerceapiintegration.services;


import com.pm.ecommerceapiintegration.dto.ProductDto;
import com.pm.ecommerceapiintegration.entity.Product;
import com.pm.ecommerceapiintegration.mapper.ProductMapper;
import com.pm.ecommerceapiintegration.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("productService")
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getProductById(Long id) throws Exception {
      return  productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product saved= productRepository.save(ProductMapper.toEntity(productDto));
        return ProductMapper.toDto(saved);
    }
}
