package com.pm.ecommerceapiintegration.APIgateway;

import com.pm.ecommerceapiintegration.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

    List<CategoryDTO> getAllCategories() throws IOException;



}
