package demo.jsb2.modules.products.adapters.web;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.jsb2.modules.products.adapters.dto.ProductAllResponseDTO;
import demo.jsb2.modules.products.adapters.dto.ProductSingleResponseDTO;
import demo.jsb2.modules.products.adapters.mappers.ProductMapper;
import demo.jsb2.modules.products.domain.models.ProductModel;
import demo.jsb2.modules.products.domain.services.ProductQueryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/product")
public class ProductQueryController extends ProductController {
    private final ProductQueryService productQueryApplication;

    @PostConstruct
    public void init() {
        nameClass = "ProductQueryController";
    }

    @GetMapping("/{sku}")
    public ResponseEntity<ProductSingleResponseDTO> getOneProduct(@PathVariable String sku) {
        startMethod("getOneProduct");
        ProductModel productGot = productQueryApplication.getOneProduct(sku);
        endMethod("getOneProduct");
        return ResponseEntity.ok().body(ProductMapper.toProductSingleResponseDTO(productGot));
    }

    @GetMapping
    public ResponseEntity<ProductAllResponseDTO> getAllProducts(
            @RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer size,
            @RequestParam(required = false) Integer category) {
        startMethod("getAllProducts");

        Page<ProductModel> productsFound = productQueryApplication.findAllPageable(page, size, category);

        endMethod("getAllProducts");
        return ResponseEntity.ok().body(ProductMapper.toProductAllResponseDTO(productsFound));
    }

}
