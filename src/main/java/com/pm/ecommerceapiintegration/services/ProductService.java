package com.pm.ecommerceapiintegration.services;


import com.pm.ecommerceapiintegration.dto.ProductDto;
import com.pm.ecommerceapiintegration.entity.Category;
import com.pm.ecommerceapiintegration.entity.Product;
import com.pm.ecommerceapiintegration.mapper.ProductMapper;
import com.pm.ecommerceapiintegration.repository.CategoryRepository;
import com.pm.ecommerceapiintegration.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component("productService")
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDto getProductById(Long id) throws Exception {
      return  productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) throws Exception{
        Category category=categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(()->new Exception("Category not found"));
        Product saved= productRepository.save(ProductMapper.toEntity(productDto,category));
        return ProductMapper.toDto(saved);
    }

    @Override
    public List<ProductDto> getProductByMatch(String keyword) throws Exception {

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new IllegalArgumentException("Search keyword cannot be empty");
        }
        List<ProductDto> dto=new ArrayList<>();

        for(Product product:productRepository.searchFullText(keyword)){
            dto.add(ProductMapper.toDto(product));
        }

        return dto;
    }
}
