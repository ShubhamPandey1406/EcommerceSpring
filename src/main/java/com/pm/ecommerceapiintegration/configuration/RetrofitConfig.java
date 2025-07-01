package com.pm.ecommerceapiintegration.configuration;

import com.pm.ecommerceapiintegration.APIgateway.API.FakeStoreCategoryAPI;
import com.pm.ecommerceapiintegration.APIgateway.API.FakeStoreProductAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {


    @Bean
    public Retrofit retrofit()
    {
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }


    @Bean
    public FakeStoreCategoryAPI fakeStoreCategoryAPI(Retrofit retrofit)

    {
        return retrofit.create(FakeStoreCategoryAPI.class);

    }

    @Bean

    public FakeStoreProductAPI  fakeStoreProductAPI(Retrofit retrofit)
    {
        return retrofit.create(FakeStoreProductAPI.class);
    }
}
