package demo.jsb2.utils;

import java.time.format.DateTimeFormatter;

public class ObjectUtil {
    public static boolean isBlankString(String string) {
        return string == null || string.isBlank();
    }

    public static DateTimeFormatter getFormatterDefault() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }
}
