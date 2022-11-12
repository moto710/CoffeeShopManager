package product;

import utils.InstantUtils;
import utils.ReadWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static enums.FilePath.PRODUCT_LIST_PATH;


public class ProductManagement {
    private static List<Product> productList;

    public ProductManagement() {
        List<Product> productList = new ArrayList<>();
        this.productList = productList;

    }

    public static List<Product> products() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public static List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        List<String> lines = ReadWriteFile.read(PRODUCT_LIST_PATH.getPath());
        for (String line : lines) {
            productList.add(Product.parseProduct(line));
        }
        return productList;
    }


    public static void addProduct(Product product) {
        renderProduct();
        List<Product> products = findAll();
        products.add(product);
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), products);
        renderProduct();
    }

    public static void renderProduct() {
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋MENU㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
        System.out.printf("\n\t%-16s %-36s %-26s %-10s %s\n", "ID", "Tên Món Ăn", "Giá Tiền", "Số Lượng", "㊋");
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(PRODUCT_LIST_PATH.getPath()));
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
        System.out.printf("\n\t%-16s %-36s %-26s %-10s %s\n", productList.get(0), productList.get(1), InstantUtils.doubleToVND(Double.parseDouble(productList.get(2))), productList.get(3));
    }

    public void editProductName(long id, String name) {
        renderProduct();
        List<Product> products = findAll();
        Product temp = searchId(id);
        temp.setName(name);
        temp.setDateUpdate(new Date());
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), products);
        renderProduct();
    }
    public void editProductInventory(long id, double inventory) {
        renderProduct();
        List<Product> products = findAll();
        Product temp = searchId(id);
        temp.setInventory(inventory);
        temp.setDateUpdate(new Date());
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), products);
        renderProduct();
    }
    public void editProductUnit(long id, String unit) {
        renderProduct();
        List<Product> products = findAll();
        Product temp = searchId(id);
        temp.setUnit(unit);
        temp.setDateUpdate(new Date());
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), products);
        renderProduct();
    }
    public void editProductPrice(long id, double price) {
        renderProduct();
        List<Product> products = findAll();
        Product temp = searchId(id);
        temp.setPrice(price);
        temp.setDateUpdate(new Date());
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), products);
        renderProduct();
    }
    public void editProductSupplier(long id, String supplier) {
        renderProduct();
        List<Product> products = findAll();
        Product temp = searchId(id);
        temp.setSupplier(supplier);
        temp.setDateUpdate(new Date());
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), products);
        renderProduct();
    }

    public void removeProduct(long id) {
        renderProduct();
        List<Product> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                break;
            }
        }
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), list);
        renderProduct();
    }

    public static Product searchId(long id) {
        List<Product> products = findAll();
        Product temp = new Product();
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                temp = products.get(i);
                count++;
                break;
            } else if (count == 0 && i == products.size() - 1) {
                temp = null;
            }
        }
        return temp;
    }

    public static List<Product> searchName(String name) {
        List<Product> products = findAll();
        List<Product> sameName = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().toUpperCase().contains(name.toUpperCase())) {
                sameName.add(products.get(i));
                count++;
            } else if (count == 0 && i == products.size() - 1) {
                sameName = null;
            }
        }
        return sameName;
    }

    public static List<Product> searchInventory(double inventory) {
        List<Product> products = findAll();
        List<Product> sameInventory = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getInventory() == inventory) {
                sameInventory.add(products.get(i));
                count++;
            } else if (count == 0 && i == products.size() - 1) {
                sameInventory = null;
            }
        }
        return sameInventory;
    }


    public static List<Product> searchPrice(int price) {
        List<Product> products = findAll();
        List<Product> sameEntryPrice = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() == price) {
                sameEntryPrice.add(products.get(i));
                count++;
            } else if (count == 0 && i == products.size() - 1) {
                sameEntryPrice = null;
            }
        }
        return sameEntryPrice;
    }


    public static List<Product> searchUnit(String unit) {
        List<Product> products = findAll();
        List<Product> sameUnit = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getUnit().toUpperCase().contains(unit.toUpperCase())) {
                sameUnit.add(products.get(i));
                count++;
            } else if (count == 0 && i == products.size() - 1) {
                sameUnit = null;
            }
        }
        return sameUnit;
    }


    public static List<Product> searchSupplier(String supplier) {
        List<Product> products = findAll();
        List<Product> sameSupplier = new ArrayList<>();
        for (Product product : products) {
            if (product.getSupplier().equalsIgnoreCase(supplier)) {
                sameSupplier.add(product);
            }
        }
        return sameSupplier;
    }

    public static boolean isNameExist(String name) {
        List<Product> products = findAll();
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(name)) {
                flag = true;
                count++;
            } else if (i == products.size() - 1 && count == 0) {
                flag = false;
            }
        }

        return flag;
    }
}


