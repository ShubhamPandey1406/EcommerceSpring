package com.pm.ecommerceapiintegration.services;

import com.pm.ecommerceapiintegration.dto.CategoryDTO;
import com.pm.ecommerceapiintegration.dto.CategoryWithProductDTO;
import com.pm.ecommerceapiintegration.dto.ProductDto;
import com.pm.ecommerceapiintegration.entity.Category;
import com.pm.ecommerceapiintegration.mapper.CategoryMapper;
import com.pm.ecommerceapiintegration.mapper.ProductMapper;
import com.pm.ecommerceapiintegration.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component("categoryService")
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> dtos = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            dtos.add(CategoryMapper.toCategoryDTO(category));
        }
        return dtos;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategory(categoryDTO);
        categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    @Override
    public CategoryDTO getCategoryByName(String name) throws Exception {

        Category category = categoryRepository.findByName(name)
                .orElseThrow(() -> new Exception("Category not found with name: " + name));

        return CategoryMapper.toCategoryDTO(category);
//        Category category=categoryRepository.findByName(name)
//        .orElseThrow(()->new Exception("Category not found" + name));
//        return CategoryMapper.toCategoryDTO(category);
    }

    @Override
    public CategoryWithProductDTO getCategoryWithProducts(long id) throws Exception {

        Category category=categoryRepository.findById(id)
                .orElseThrow(() -> new Exception("Category not found with id: " + id));

        List<ProductDto> products =category.getProducts()
                .stream()
                .map(product-> ProductMapper.toDto(product))
                .collect(Collectors.toList());

        return CategoryWithProductDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .products(products)
                .build();


    }


}
