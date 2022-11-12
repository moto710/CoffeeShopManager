package utils;

import product.ProductManagement;

import java.util.Scanner;

public class OrderValidateUltils {
    static Scanner scanner = new Scanner(System.in);

    public static double inputPrice() {
        double price = 0;
        do {
            System.out.println("Nhập giá vật phẩm (Giá phải lớn hơn 5000 VNĐ, Ví dụ : 6000) : ");
            price = Double.parseDouble(scanner.nextLine());
            if (price < 5000) {
                System.out.println("Số tiền quá thấp vui lòng nhập lại!!");
            }
        } while (price < 5000);
        return price;
    }

    public static String inputFoodName() {
        String foodName = "";
        do {
            System.out.println("Nhập tên Món Ăn (Ví dụ Bún Bò Huế) : ");
            foodName = scanner.nextLine();
            if (!ValidateUltils.isNameValid(foodName)) {
                System.out.println("Tên chưa đúng định dạng vui lòng nhập lại!!");
            }
            if (ProductManagement.isNameExist(foodName)) {
                System.out.println("Tên món ăn đã có, vui lòng nhập lại !!");
//                ProductManagement.addProduct();
                break;
            }
        } while (!ValidateUltils.isNameValid(foodName));
        return foodName;
    }

    public static double inputInventory() {
        double inventory = 0;
        do {
            System.out.println("Nhập số lượng vật phẩm (không được < 1):");
            inventory = Double.parseDouble(scanner.nextLine());
            if (inventory < 1) {
                System.out.println("Số lượng không đúng quy định, vui lòng nhập lại!!");
            }
        } while (inventory < 1);
        return inventory;
    }

    public static String inputUnit() {
        String unit = "";
        return unit;
    }

    public static String inputSupplier() {
        String supplier = "";
        return supplier;
    }
}
