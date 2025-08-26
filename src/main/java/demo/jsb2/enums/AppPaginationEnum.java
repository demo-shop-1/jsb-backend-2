package demo.jsb2.enums;

public enum AppPaginationEnum {
    PAGE_INVALID("PAG-1", "Page value invalid"),
    SIZE_INVALID("PAG-2", "Size value invalid"),
    PAGE_EMPTY("PAG-3", "Page is empty"),
    SIZE_EMPTY("PAG-4", "Size is empty"),
    CATEGORY_INVALID("PAG-5", "Category invalid");

    public final String code;
    public final String message;

    private AppPaginationEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
