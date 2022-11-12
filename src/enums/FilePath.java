package enums;

public enum FilePath {
    USER_PATH("CSModule2\\data\\User.csv"),
    ORDER_PATH("CSModule2\\data\\Order.csv"),
    ORDER_ITEM_PATH("CSModule2\\data\\OrderItem.csv"),
    FOOD_MENU_PATH("CSModule2\\data\\FoodMenu.csv"),
    ALL_ORDER_PATH("CSModule2\\data\\AllOrder.csv"),
    CREATE_USER_PATH("CSModule2\\data\\CreateUser.csv"),
    DATE_ORDER_PATH("CSModule2\\data\\DayOrder.csv"),
    SAVE_USER_PATH("CSModule2\\data\\SaveUser.csv"),
    OLD_ORDER_PATH("CSModule2\\data\\ShowOldOrder.csv");
    private String path;

    private FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
