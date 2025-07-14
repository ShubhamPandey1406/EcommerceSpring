package com.pm.ecommerceapiintegration.controllers;


import com.pm.ecommerceapiintegration.dto.ProductDto;
import com.pm.ecommerceapiintegration.dto.ProductWithCategoryDTO;
import com.pm.ecommerceapiintegration.exception.productNotFoundException;
import com.pm.ecommerceapiintegration.services.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final IProductService productService;


    public ProductController(@Qualifier("productService") IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) throws Exception {

        ProductDto result= this.productService.getProductById(id);

      return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto) throws Exception {
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> getAllProductsBymatch(@RequestParam String keyword) throws Exception {

        List<ProductDto> products=productService.getProductByMatch(keyword);
        return ResponseEntity.ok().body(products);
    }
    @GetMapping("/{id}/details")
    public ResponseEntity<ProductWithCategoryDTO> getProductWithCategory(@PathVariable Long id) throws Exception {

        ProductWithCategoryDTO dto=productService.getProductWithCategory(id);
        return ResponseEntity.ok(dto);
    }

    @ExceptionHandler(productNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(productNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The new message is " + ex.getMessage());
    }
}
