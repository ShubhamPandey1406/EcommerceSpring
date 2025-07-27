package contoller;

import com.pm.ecommerceapiintegration.controllers.Categorycontroller;
import com.pm.ecommerceapiintegration.dto.CategoryDTO;
import com.pm.ecommerceapiintegration.exception.GlobalExceptionHandler;
import com.pm.ecommerceapiintegration.services.ICategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @Mock
   private ICategoryService categoryService;

    @InjectMocks
    private Categorycontroller categorycontroller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp()
    {
       // MockitoAnnotations.openMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(categorycontroller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    @DisplayName("GET /api/categories should return all categories")
    void getAllCategories_shouldReturnAllCategories() throws Exception {
        //Arrange
        List<CategoryDTO> categories= new ArrayList<>();

        categories.add(CategoryDTO.builder().name("Electronics").id(1L).build());
        categories.add(CategoryDTO.builder().name("Books").id(2L).build());
        categories.add(CategoryDTO.builder().name("Clothing").id(3L).build());

       // when(categoryService.getAllCategories()).thenReturn(categories);
       Mockito.when(categoryService.getAllCategories()).thenReturn(categories);

      mockMvc.perform(get("/api/categories").contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$").isArray())
              .andExpect(jsonPath( "$[0].id").value(1))
              .andExpect(jsonPath( "$[0].name").value("Electronics"))
              .andExpect(jsonPath( "$[1].id").value(2))
              .andExpect(jsonPath( "$[1].name").value("Books"))
              .andExpect(jsonPath( "$[2].id").value(3))
              .andExpect(jsonPath( "$[2].name").value("Clothing"));

        verify(categoryService, times(1)).getAllCategories();



    }
}
