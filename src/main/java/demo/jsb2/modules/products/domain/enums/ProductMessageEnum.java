package demo.jsb2.modules.products.domain.enums;

public enum ProductMessageEnum {
    // field CODE has to be unique
    PRODUCT_ERROR("PROD-1", "There is an error with this product"),
    SKU_BLANK("PROD-2", "SKU is blank"),
    SKU_REPEATED("PROD-3", "This SKU already exists"),
    NAME_BLANK("PROD-4", "Name is blank"),
    CATEGORY_NULL("PROD-4", "Category is emtpy"),
    DESCRIPTION_BLANK("PROD-5", "Description is blank"),
    SKU_MIN("PROD-6", "SKU is shorter"),
    UNIT_PRICE_MIN("PROD-7", "Unit Price has to be a positive value"),
    UNIT_PRICE_NULL("PROD-8", "Unit Price is empty"),
    UNIT_IN_STOCK_NULL("PROD-9", "Unit In Stock is empty"),
    UNIT_IN_STOCK_MIN("PROD-10", "Unit In Stock has to be a positive value"),
    CATEGORY_NOT_EXIST("PROD-11", "This category does not exist"),
    SKU_NOT_EXIST("PROD-12", "This SKU does not exist"),
    IS_ACTIVE_NULL("PROD-13", "Field isActive is empty"),
    PRODUCT_NOT_EXIST("PROD-14", "There is no product with this SKU");

    public final String code;
    public final String message;

    private ProductMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
