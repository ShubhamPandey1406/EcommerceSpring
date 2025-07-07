package com.pm.ecommerceapiintegration.APIgateway;

import com.pm.ecommerceapiintegration.dto.CategoryDTO;
//import org.springframework.context.annotation.Primary;
import com.pm.ecommerceapiintegration.dto.FakeStoreCategoryResponseDTO;
import com.pm.ecommerceapiintegration.mapper.GetAllCategoriesMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{


    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreRestTemplateGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        String url="https://fakestoreapi.in/api/products/category";

     ResponseEntity<FakeStoreCategoryResponseDTO> response= restTemplate.getForEntity(url, FakeStoreCategoryResponseDTO.class);

     if(response.getBody()==null)
     {
         throw  new IOException("Failed to fetch categories from Fakestore API");
     }
       // return List.of();
//        return response.getBody().getCategories().stream()
//                .map( category-> CategoryDTO.builder()
//                        .name(category)
//                        .build())
//                .toList();

        return GetAllCategoriesMapper.toCategoryDto(response.getBody());
    }
}
