package com.pm.ecommerceapiintegration.controllers;


import com.pm.ecommerceapiintegration.dto.ProductDto;
import com.pm.ecommerceapiintegration.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) throws Exception {

        ProductDto result= this.productService.getProductById(id);

      return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto)  {
        return ResponseEntity.ok(productService.createProduct(dto));
    }
}
