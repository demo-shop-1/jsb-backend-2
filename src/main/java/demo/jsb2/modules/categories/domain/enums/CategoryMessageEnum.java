package demo.jsb2.modules.categories.domain.enums;

public enum CategoryMessageEnum {
    // field code has to be unique
    ID_INVALID("CATE-1", "ID has to be a positive value"),
    ID_REPEATED("CATE-2", "This ID already exists"),
    NAME_REPEATED("CATE-3", "This Name already exists"),
    CATEGORY_ERROR("CATE-4", "There is an error with this category"),
    NAME_BLANK("CATE-5", "Name is blank"),
    CATEGORY_NOT_EXIST("CATE-6", "There is no Category with this ID");

    public final String code;
    public final String message;

    private CategoryMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
