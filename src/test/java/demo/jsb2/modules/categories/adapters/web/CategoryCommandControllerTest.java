package demo.jsb2.modules.categories.adapters.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import demo.jsb2.modules.categories.adapters.dto.CategoryCreateRequestDTO;
import demo.jsb2.modules.categories.adapters.dto.CategoryCreateResponseDTO;
import demo.jsb2.modules.categories.domain.enums.CategoryMessageEnum;
import demo.jsb2.modules.categories.domain.exceptions.CategoryValidationException;
import demo.jsb2.modules.categories.domain.models.CategoryModel;
import demo.jsb2.modules.categories.domain.services.CategoryCommandService;

public class CategoryCommandControllerTest {

    @Mock
    private CategoryCommandService categoryCommandApplication;

    @InjectMocks
    private CategoryCommandController categoryCommandController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCategory_Ok() {
        // Arrange
        CategoryCreateRequestDTO request = new CategoryCreateRequestDTO();
        request.setName("Javas");

        // Act
        when(categoryCommandApplication.createCategory(Mockito.any(CategoryModel.class)))
                .then(invocation -> {
                    CategoryModel category = invocation.getArgument(0);
                    category.setId(1);
                    return category;
                });
        ResponseEntity<CategoryCreateResponseDTO> responseEntity = categoryCommandController.createCategory(request);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        CategoryCreateResponseDTO body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals(1, body.getId());
        assertEquals("Javas", body.getName());
    }

    @Test
    void createCategory_Nok() {
        // Arrange
        CategoryCreateRequestDTO request = new CategoryCreateRequestDTO();
        request.setName("Javas");

        // Act
        when(categoryCommandApplication.createCategory(isNotNull()))
                .thenThrow(new CategoryValidationException(CategoryMessageEnum.NAME_REPEATED.code,
                        CategoryMessageEnum.NAME_REPEATED.message));

        // Assert
        Exception exception = assertThrows(CategoryValidationException.class, () -> {
            categoryCommandController.createCategory(request);
        });
        assertEquals(CategoryValidationException.class, exception.getClass());
        assertEquals(CategoryMessageEnum.NAME_REPEATED.message, exception.getMessage());
        verify(categoryCommandApplication).createCategory(isNotNull());
    }

}
