package enums;

public enum FilePath {
    USER_LIST_PATH("data\\User.csv"),
    ORDER_PATH("data\\Order.csv"),
    ORDER_ITEM_PATH("data\\OrderItem.csv"),
    PRODUCT_LIST_PATH("data\\ProductList.csv"),
    CART_LIST_PATH("data\\CartList.csv"),
    CUSTOMER_LIST_PATH("data\\CustomerList.csv");

    private String path;

    private FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
