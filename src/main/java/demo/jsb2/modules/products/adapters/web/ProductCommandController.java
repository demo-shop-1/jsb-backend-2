package demo.jsb2.modules.products.adapters.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.jsb2.modules.products.adapters.dto.ProductCreateRequestDTO;
import demo.jsb2.modules.products.adapters.dto.ProductCreateResponseDTO;
import demo.jsb2.modules.products.adapters.dto.ProductUpdateRequestDTO;
import demo.jsb2.modules.products.adapters.dto.ProductUpdateResponseDTO;
import demo.jsb2.modules.products.adapters.mappers.ProductMapper;
import demo.jsb2.modules.products.domain.models.ProductModel;
import demo.jsb2.modules.products.domain.services.ProductCommandService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/product")
public class ProductCommandController extends ProductController {
    private final ProductCommandService productCommandApplication;

    @PostConstruct
    public void init() {
        nameClass = "ProductCommandController";
    }

    @PostMapping("/create")
    public ResponseEntity<ProductCreateResponseDTO> createOneProduct(@RequestBody ProductCreateRequestDTO request) {
        startMethod("createProduct");

        ProductModel productCreated = productCommandApplication.createOneProduct(ProductMapper.toProductModel(request));

        endMethod("createProduct");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProductMapper.toProductCreateResponseDTO(productCreated));
    }

    @PutMapping("/update/{sku}")
    public ResponseEntity<ProductUpdateResponseDTO> updateOneProduct(@PathVariable String sku,
            @RequestBody ProductUpdateRequestDTO request) {
        startMethod("updateProduct");

        ProductModel productToUpdate = ProductMapper.toProductModel(request);
        productToUpdate.setSku(sku);
        ProductModel productUpdated = productCommandApplication.updateOneProduct(productToUpdate);

        endMethod("updateProduct");
        return ResponseEntity.status(HttpStatus.OK)
                .body(ProductMapper.toProductUpdateResponseDTO(productUpdated));
    }

    @DeleteMapping("/delete/{sku}")
    public ResponseEntity<Void> deleteOneProduct(@PathVariable String sku) {
        startMethod("deleteOneProduct");
        productCommandApplication.deleteOneProduct(sku);
        endMethod("deleteOneProduct");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
