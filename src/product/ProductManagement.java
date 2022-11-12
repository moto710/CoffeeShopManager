package product;

import utils.InstantUtils;
import utils.OrderValidateUltils;
import utils.ReadWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static enums.FilePath.FOOD_MENU_PATH;


public class ProductManagement {
    private static List<Product> productList;

    public ProductManagement() {
        List<Product> productList = new ArrayList<>();
        this.productList = productList;

    }

    public static List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public static List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        List<String> lines = ReadWriteFile.read(FOOD_MENU_PATH.getPath());
        for (String line : lines) {
            productList.add(Product.parseProduct(line));
        }
        return productList;
    }

//    public boolean checkProductInList(Product product) {
//        if (!productList.isEmpty()) {
//            for (Product item : productList) {
//                if (product == item)
//                    return true;
//            }
//        }
//        return false;
//    }

//    public static boolean checkNameInList(String name) {
//        List<Product> products = findAll();
//        if (!products.isEmpty()) {
//            for (Product item : products) {
//                String tamp = item.getName();
//                if (tamp.equals(name))
//                    return true;
//            }
//
//        }
//        return false;
//    }


    public static void addProduct(Product product) {
        List<Product> products = findAll();
        renderProduct();

        products.add(product);
        ReadWriteFile.write(FOOD_MENU_PATH.getPath(), products);
        renderProduct();
    }

    public static void renderProduct() {
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋MENU㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
        System.out.printf("\n\t%-16s %-36s %-26s %-10s %s\n", "ID", "Tên Món Ăn", "Giá Tiền", "Số Lượng", "㊋");
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(FOOD_MENU_PATH.getPath()));
            while ((line = br.readLine()) != null) {
                printProduct(parseCsvLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static void printProduct(List<String> productList) {
        System.out.printf("\n\t%-16s %-36s %-26s %-10s %s\n", productList.get(0), productList.get(1),InstantUtils.doubleToVND(Double.parseDouble(productList.get(2))) , productList.get(3));
    }


    public void editProduct() {
        renderProduct();
        List<Product> products = findAll();

        Scanner input = new Scanner(System.in);
        System.out.println("Nhập y nếu muốn chỉnh sửa hoặc nhập b để quay lại menu chính: ");
        String choice = input.nextLine();
        switch (choice) {
            case "y":
                System.out.println("Nhập ID Muốn chỉnh sửa:  ");
                Long id = Long.parseLong(input.nextLine());
                int count = 0;
                for (Product dish : products) {
                    Long tamp = dish.getId();
                    if (tamp.equals(id)) {
//                        products.remove(dish);
                        String name = OrderValidateUltils.inputFoodName();
                        double price = OrderValidateUltils.inputPrice();
                        double inventory = OrderValidateUltils.inputInventory();
                        dish.setName(name);
                        dish.setPrice(price);
                        dish.setInventory(inventory);
                        count++;
                        ReadWriteFile.write(FOOD_MENU_PATH.getPath(), products);
                        renderProduct();
                        break;
                    }
                }
                if (count == 0) {
                    System.out.println("ID không tồn tại vui lòng nhập lại!");
                    editProduct();
                }
                break;
            case "b":
                break;
            default:
                System.out.println("Vui Lòng Nhập Lại!");
                editProduct();
        }
    }


    public void removeProduct(long id) {
        renderProduct();
        List<Product> list = findAll();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                break;
            }
        }
        ReadWriteFile.write(FOOD_MENU_PATH.getPath(), list);
        renderProduct();
    }
    public static Product searchId(long id) {
        Product temp = new Product();
        int count = 0;
        for (int i = 0; i < getProductList().size(); i++) {
            if (getProductList().get(i).getId() == id) {
                temp = getProductList().get(i);
                count++;
                break;
            } else if (count == 0 && i == getProductList().size() - 1){
                temp = null;
            }
        }
        return temp;
    }

    public static List<Product> searchName(String name) {
        List<Product> sameName = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().toUpperCase().contains(name.toUpperCase())) {
                sameName.add(productList.get(i));
                count++;
            } else if (count == 0 && i == productList.size() - 1) {
                sameName = null;
            }
        }
        return sameName;
    }
    public static List<Product> searchInventory(double inventory) {
        List<Product> sameInventory = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getInventory() == inventory) {
                sameInventory.add(productList.get(i));
                count++;
            } else if (count == 0 && i == productList.size() - 1) {
                sameInventory = null;
            }
        }
        return sameInventory;
    }


    public static List<Product> searchEntryPrice(int entryPrice) {
        List<Product> sameEntryPrice = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() == entryPrice) {
                sameEntryPrice.add(productList.get(i));
                count++;
            } else if (count == 0 && i == productList.size() - 1) {
                sameEntryPrice = null;
            }
        }
        return sameEntryPrice;
    }


    public static List<Product> searchUnit(String unit) {
        List<Product> sameUnit = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getUnit().toUpperCase().contains(unit.toUpperCase())) {
                sameUnit.add(productList.get(i));
                count++;
            } else if (count == 0 && i == productList.size() - 1) {
                sameUnit = null;
            }
        }
        return sameUnit;
    }


    public static List<Product> searchSupplier(String supplier) {
        List<Product> sameSupplier = new ArrayList<>();
        for (Product product : productList) {
            if (product.getSupplier().toUpperCase().contains(supplier.toUpperCase())) {
                sameSupplier.add(product);
            }
        }
        return sameSupplier;
    }

    public void sortProduct(Comparator<Product> comparator) {
        productList.sort(comparator);
    }
}


