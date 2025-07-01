package com.pm.ecommerceapiintegration.APIgateway.API;

import com.pm.ecommerceapiintegration.dto.FakeStoreCategoryResponseDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

@Component
public interface FakeStoreCategoryAPI {

    @GET("products/category")
    Call<FakeStoreCategoryResponseDTO> getAllFakeCategories() throws IOException;

//    @GET("products/{id}")
//    Call<FakeStoreCategoryResponseDTO> getFakeCategoryById(@Path("id") int id) throws IOException;
}
