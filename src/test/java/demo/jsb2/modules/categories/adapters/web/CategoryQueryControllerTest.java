package demo.jsb2.modules.categories.adapters.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import demo.jsb2.modules.categories.adapters.dto.CategoryGetOneResponseDTO;
import demo.jsb2.modules.categories.domain.enums.CategoryMessageEnum;
import demo.jsb2.modules.categories.domain.exceptions.CategoryValidationException;
import demo.jsb2.modules.categories.domain.models.CategoryModel;
import demo.jsb2.modules.categories.domain.services.CategoryQueryService;

public class CategoryQueryControllerTest {

    @InjectMocks
    private CategoryQueryController categoryQueryController;

    @Mock
    private CategoryQueryService categoryQueryApplication;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getOneCategory_OK() {
        // Arrange
        CategoryModel categoryFound = new CategoryModel();
        categoryFound.setId(1);
        categoryFound.setName("Javas");
        categoryFound.setDateCreated(LocalDateTime.now());
        // Act
        when(categoryQueryApplication.findById(1)).thenReturn(categoryFound);
        ResponseEntity<CategoryGetOneResponseDTO> responseEntity = categoryQueryController.getOneCategory(1);

        // Assert
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
        CategoryGetOneResponseDTO body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals(1, body.getId());
        assertEquals("Javas", body.getName());

    }

    @Test
    void getOneCategory_NOK() {
        // Arrange
        // Act
        when(categoryQueryApplication.findById(1))
                .thenThrow(new CategoryValidationException(CategoryMessageEnum.CATEGORY_NOT_EXIST.code,
                        CategoryMessageEnum.CATEGORY_NOT_EXIST.message));

        // Assert
        Exception exception = assertThrows(CategoryValidationException.class, () -> {
            categoryQueryController.getOneCategory(1);
        });
        assertEquals(CategoryValidationException.class, exception.getClass());
        assertEquals(CategoryMessageEnum.CATEGORY_NOT_EXIST.message, exception.getMessage());
        verify(categoryQueryApplication).findById(isNotNull());
    }
}
