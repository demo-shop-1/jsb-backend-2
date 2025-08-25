package demo.jsb2.modules.products.adapters.aop;

import java.util.Set;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import demo.jsb2.modules.products.adapters.entity.ProductEntity;
import demo.jsb2.modules.products.adapters.mappers.ProductMapper;
import demo.jsb2.modules.products.domain.enums.ProductMessageEnum;
import demo.jsb2.modules.products.domain.models.ProductModel;
import demo.jsb2.modules.products.domain.utils.ProductUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@Order(1)
@RequiredArgsConstructor
public class ProductAspect {
    protected static final Logger logger = Logger.getLogger(ProductAspect.class.getName());
    private final Validator validator;

    @Before("ProductServicePointcuts.validateCommand() && args(entity)")
    public void validateCommandBefore(Object entity) {
        if (entity instanceof ProductModel) {
            ProductEntity productToValidate = ProductMapper.toProductEntity((ProductModel) entity);
            Set<ConstraintViolation<Object>> violations = validator.validate(productToValidate);

            if (!violations.isEmpty()) {
                String error = violations.stream().map(ConstraintViolation::getMessage)
                        .reduce((a, b) -> a + "; " + b)
                        .orElse("Invalid entity");
                logger.warning(String.format("Info > ProductAspect > validateCommandBefore > There is an error with this entity: %s", error));
                ProductUtil.throwValidationError(ProductMessageEnum.PRODUCT_ERROR);
            }
        }

    }
}
