package demo.jsb2.modules.products.adapters.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.jsb2.modules.products.adapters.dto.ProductCreateRequestDTO;
import demo.jsb2.modules.products.adapters.dto.ProductCreateResponseDTO;
import demo.jsb2.modules.products.adapters.mappers.ProductMapper;
import demo.jsb2.modules.products.domain.models.ProductModel;
import demo.jsb2.modules.products.domain.services.ProductCommandService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductCommandController extends ProductController {
    private final ProductCommandService productCommandApplication;

    @PostConstruct
    public void init() {
        nameClass = "ProductCommandController";
    }

    @PostMapping("/product/create")
    public ResponseEntity<ProductCreateResponseDTO> createProduct(@RequestBody ProductCreateRequestDTO request) {
        startMethod("createProduct");

        ProductModel productCreated = productCommandApplication.createProduct(ProductMapper.toProductModel(request));

        endMethod("createProduct");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProductMapper.toProductCreateResponseDTO(productCreated));
    }

}
