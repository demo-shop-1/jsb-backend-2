package demo.jsb2.modules.products.adapters.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductServicePointcuts {
    @Pointcut("execution(* demo.jsb2.modules.products.adapters.db.ProductCommandJpaRepository.*(..))")
    public void validateCommand() {
    }
}
