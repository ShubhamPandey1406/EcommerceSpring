package com.pm.ecommerceapiintegration.APIgateway.API;

import com.pm.ecommerceapiintegration.dto.FakeStoreCategoryResponseDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;

@Component
public interface FakeStoreCategoryAPI {

    @GET("products/category")
    Call<FakeStoreCategoryResponseDTO> getAllFakeCategories() throws IOException;
}
