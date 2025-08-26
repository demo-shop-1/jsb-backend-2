package demo.jsb2.enums;

public enum AppIntegerEnum {
    PAGE_SIZE_DEFAULT(0),
    PAGE_SIZE_MIN(0),
    PAGE_SIZE_MAX(10),
    SIZE_DEFAULT(5),
    SIZE_MIN(1),
    SIZE_MAX(25),
    CATEGORY_MIN(1);

    public final Integer value;

    private AppIntegerEnum(Integer value) {
        this.value = value;
    }
}
