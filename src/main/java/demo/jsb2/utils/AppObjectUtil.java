package demo.jsb2.utils;

import java.time.format.DateTimeFormatter;

public class AppObjectUtil {

    public static boolean isNull(Object request) {
        return request == null;
    }

    public static boolean isBlankString(String string) {
        return string == null || string.isBlank();
    }

    public static DateTimeFormatter getFormatterLocalDateTimeDefault() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }
}
