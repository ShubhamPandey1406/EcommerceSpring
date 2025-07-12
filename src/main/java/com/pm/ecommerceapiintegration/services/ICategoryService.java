package com.pm.ecommerceapiintegration.services;

import com.pm.ecommerceapiintegration.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;
 public interface ICategoryService {

    List<CategoryDTO> getAllCategories() throws IOException;

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategoryByName(String categoryName) throws Exception;


}
