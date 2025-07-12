package com.pm.ecommerceapiintegration.controllers;

import com.pm.ecommerceapiintegration.dto.CategoryDTO;
import com.pm.ecommerceapiintegration.services.FakeCategoryService;
import com.pm.ecommerceapiintegration.services.ICategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class Categorycontroller {

    private final ICategoryService categoryService;

    public Categorycontroller(@Qualifier("categoryService") ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
   public ResponseEntity<?>getAllCategories(@RequestParam(required=false) String name) throws Exception {

       if(name!=null && !name.isBlank()) {
           CategoryDTO dto=categoryService.getCategoryByName(name);
           return ResponseEntity.ok(dto);
       }
       else {


           List<CategoryDTO> categories = categoryService.getAllCategories();
           return ResponseEntity.ok(categories);
       }

    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws IOException {
        CategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(createdCategory);
    }

//    @GetMapping("/{name}")
//    public ResponseEntity<CategoryDTO> getCategory(@PathVariable String name) throws Exception {
//        CategoryDTO dto=categoryService.getCategoryByName(name);
//        return ResponseEntity.ok(dto);
//
//    }



}
