package service;

import models.Product;
import utils.ReadWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static enums.FilePath.PRODUCT_LIST_PATH;
import static utils.DateUtils.formatDateToString;


public class ProductService {
    private static List<Product> productList;

    public ProductService() {
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

    public static void renderProduct() {
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
        System.out.printf("%s, %s, %s, %s, %s, %s, %s, %s\n", productList.get(0), productList.get(1), productList.get(2),
                productList.get(3), productList.get(4), productList.get(5), productList.get(6), productList.get(7));
    }

    public static void addProduct(Product product) {
        List<Product> products = findAll();
        products.add(product);
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), products);
    }

    public static Product getProduct(long id) {
        List<Product> products = findAll();
        Product temp = new Product();
        for (Product product : products) {
            if (product.getId() == id) {
                temp = product;
                break;
            }
        }
        return temp;
    }

    public static void editProductName(long id, String name) {
        List<Product> products = findAll();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.get(i).setName(name);
                products.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), products);
    }

    public void editProductInventory(long id, double inventory) {
        List<Product> products = findAll();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.get(i).setInventory(inventory);
                products.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), products);
    }

    public void editProductUnit(long id, String unit) {
        List<Product> products = findAll();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.get(i).setUnit(unit);
                products.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), products);
    }

    public void editProductPrice(long id, double price) {
        List<Product> products = findAll();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.get(i).setPrice(price);
                products.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), products);
    }

    public void editProductSupplier(long id, String supplier) {
        List<Product> products = findAll();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.get(i).setSupplier(supplier);
                products.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), products);
    }

    public void removeProduct(long id) {
        List<Product> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                break;
            }
        }
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), list);
    }

    public static Product searchId(long id) {
        List<Product> products = findAll();
        Product temp = null;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                temp = products.get(i);
                break;
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
}


