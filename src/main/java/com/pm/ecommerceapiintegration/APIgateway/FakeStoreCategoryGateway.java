package com.pm.ecommerceapiintegration.APIgateway;

import com.pm.ecommerceapiintegration.APIgateway.API.FakeStoreCategoryAPI;
import com.pm.ecommerceapiintegration.dto.CategoryDTO;
import com.pm.ecommerceapiintegration.dto.FakeStoreCategoryResponseDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class FakeStoreCategoryGateway implements  ICategoryGateway{

    private final FakeStoreCategoryAPI fakeStoreCategoryAPI;

    public FakeStoreCategoryGateway(FakeStoreCategoryAPI fakeStoreCategoryAPI) {
        this.fakeStoreCategoryAPI = fakeStoreCategoryAPI;
    }

    @Override
    public List <CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDTO response=this.fakeStoreCategoryAPI.getAllFakeCategories().execute().body();
        if(response==null){
            throw new IOException("No Category Found");
        }

        return response.getCategories().stream()
                .map( category-> CategoryDTO.builder()
                .name(category)
                .build())
        .toList();
    }


}
