package com.pm.ecommerceapiintegration.APIgateway;

import com.pm.ecommerceapiintegration.APIgateway.API.FakeStoreProductAPI;
import com.pm.ecommerceapiintegration.dto.FakeStoreProductResponseDto;
import com.pm.ecommerceapiintegration.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class FakeStoreProductGateway implements IProductGateway{


    private final FakeStoreProductAPI fakeStoreProductAPI;

    public FakeStoreProductGateway(FakeStoreProductAPI fakeStoreProductAPI) {
        this.fakeStoreProductAPI = fakeStoreProductAPI;
    }

    @Override
    public ProductDto getProductById(Long id) throws Exception{
        FakeStoreProductResponseDto resonse= this.fakeStoreProductAPI.getFakeProduct(id).execute().body();

        if(resonse==null){
            throw new Exception("Product not found");

        }

        return resonse.getProduct();


    }
}
