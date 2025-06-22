package com.pm.ecommerceapiintegration.controllers;

import com.pm.ecommerceapiintegration.dto.CategoryDTO;
import com.pm.ecommerceapiintegration.services.FakeCategoryService;
import com.pm.ecommerceapiintegration.services.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class Categorycontroller {

    private final ICategoryService categoryService;

    public Categorycontroller(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
   public List<CategoryDTO> getAllCategories() throws IOException {

        return categoryService.getAllCategories();

    }
}
