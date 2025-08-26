package demo.jsb2.http;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import demo.jsb2.enums.AppFieldEnum;
import demo.jsb2.validations.AppPaginationValidation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component("app-pagination-interceptor")
@RequiredArgsConstructor
public class AppPaginationInterceptor implements HandlerInterceptor {
    private final AppPaginationValidation appPaginationValidation;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler)
            throws Exception {

        Boolean isValid = true;

        // mandatory fields
        appPaginationValidation.validatePageFull(request.getParameter(AppFieldEnum.PAGE.value));
        appPaginationValidation.validateSizeFull(request.getParameter(AppFieldEnum.SIZE.value));

        return isValid;
    }

}
