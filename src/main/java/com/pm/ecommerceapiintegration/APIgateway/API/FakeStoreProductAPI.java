package com.pm.ecommerceapiintegration.APIgateway.API;

import com.pm.ecommerceapiintegration.dto.FakeStoreProductResponseDto;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

@Component

public interface FakeStoreProductAPI {

    @GET("products/{id}")
    Call<FakeStoreProductResponseDto> getFakeProduct(@Path("id") Long id) throws IOException;
}
