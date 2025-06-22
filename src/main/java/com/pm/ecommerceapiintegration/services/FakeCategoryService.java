package com.pm.ecommerceapiintegration.services;

import com.pm.ecommerceapiintegration.APIgateway.ICategoryGateway;
import com.pm.ecommerceapiintegration.dto.CategoryDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeCategoryService implements ICategoryService{

    private final ICategoryGateway categoryGateway;

    public FakeCategoryService(ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
   public List<CategoryDTO> getAllCategories () throws IOException
    {
        return categoryGateway.getAllCategories();
    }
}
