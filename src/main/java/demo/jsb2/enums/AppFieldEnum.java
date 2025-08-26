package demo.jsb2.enums;

public enum AppFieldEnum {
    PAGE("page"),
    SIZE("size"),
    CATEGORY("category");

    public final String value;

    private AppFieldEnum(String value) {
        this.value = value;
    }
}
