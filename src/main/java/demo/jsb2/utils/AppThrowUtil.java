package demo.jsb2.utils;

import demo.jsb2.enums.AppPaginationEnum;
import demo.jsb2.exceptions.AppPaginationException;

public class AppThrowUtil {
    public static AppPaginationException throwPaginationException(AppPaginationEnum request) {
        return new AppPaginationException(request.code, request.message);
    }
}
