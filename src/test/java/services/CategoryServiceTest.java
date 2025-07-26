package services;


import com.pm.ecommerceapiintegration.dto.CategoryDTO;
import com.pm.ecommerceapiintegration.entity.Category;
import com.pm.ecommerceapiintegration.mapper.CategoryMapper;
import com.pm.ecommerceapiintegration.repository.CategoryRepository;
import com.pm.ecommerceapiintegration.services.CategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock//Create mock of specified class
    private CategoryRepository categoryRepository;

    @InjectMocks //
    private CategoryService categoryService;

    @Test
    @DisplayName("should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories() throws IOException {

        //Arrange
        List<Category> categories= new ArrayList<>();
        Category c1=Category.builder().name("electronics").build();
        c1.setId(1L);
        Category c2= Category.builder().name("books").build();
        c2.setId(2L);

        categories.add(c1);
        categories.add(c2);

        //when(categoryRepository.findAll()).thenReturn(categories);

        when(categoryRepository.findAll()).thenReturn(categories);




        //Act
        List<CategoryDTO> result=categoryService.getAllCategories();



        //Assert

        assertEquals(result.size(),2);

        verify(categoryRepository,times(1)).findAll();

    }

    @Test
    @DisplayName("Should Create a category")
    void createCategory_shouldCreateCategory()
    {
        CategoryDTO categoryDTO=CategoryDTO.builder().name("tv").build();

        Category category=Category.builder().name("tv").build();

        category.setId(1L);


        // 3. Set up the mock behavior
        when(categoryRepository.save(any(Category.class))).thenReturn(category);
        CategoryDTO result=categoryService.createCategory(categoryDTO);

        assertEquals("tv",result.getName());
        assertEquals(1L, result.getId());
    }
}
