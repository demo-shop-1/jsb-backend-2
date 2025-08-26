package demo.jsb2.http;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import demo.jsb2.enums.AppFieldEnum;
import demo.jsb2.enums.AppIntegerEnum;
import demo.jsb2.utils.AppObjectUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AppPaginationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        // only for all paths that required pagination
        if (path.startsWith("/product")) {
            AppHttpServletRequest wrappedRequest = new AppHttpServletRequest(request);

            // set default value for page
            if (!AppObjectUtil.isNull(wrappedRequest.getParameter(AppFieldEnum.PAGE.value))) {
                Integer page = null;
                page = Integer.parseInt(wrappedRequest.getParameter(AppFieldEnum.PAGE.value));

                if (page < AppIntegerEnum.PAGE_SIZE_MIN.value) {
                    wrappedRequest.setParameter(AppFieldEnum.PAGE.value, AppIntegerEnum.PAGE_SIZE_MIN.value.toString());
                } else if (page > AppIntegerEnum.PAGE_SIZE_MAX.value) {
                    wrappedRequest.setParameter(AppFieldEnum.PAGE.value, AppIntegerEnum.PAGE_SIZE_MAX.value.toString());
                }
            }

            // set default value for SIZE
            if (!AppObjectUtil.isNull(wrappedRequest.getParameter(AppFieldEnum.SIZE.value))) {
                Integer size = null;
                size = Integer.parseInt(wrappedRequest.getParameter(AppFieldEnum.SIZE.value));

                if (size < AppIntegerEnum.SIZE_MIN.value) {
                    wrappedRequest.setParameter(AppFieldEnum.SIZE.value, AppIntegerEnum.SIZE_MIN.value.toString());
                } else if (size > AppIntegerEnum.SIZE_MAX.value) {
                    wrappedRequest.setParameter(AppFieldEnum.SIZE.value, AppIntegerEnum.SIZE_MAX.value.toString());
                }
            }

            // continue with the request
            filterChain.doFilter(wrappedRequest, response);
            return;
        }

        filterChain.doFilter(request, response);
    }

}
