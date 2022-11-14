package order.order;

import product.Product;
import utils.ReadWriteFile;
import utils.InstantUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static enums.FilePath.ORDER_PATH;
import static enums.FilePath.PRODUCT_LIST_PATH;

public class OrderManager {
    public List<Order> orders;

    public OrderManager() {
        List<Order> orders = new ArrayList<>();
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public static List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        List<String> lines = ReadWriteFile.read(ORDER_PATH.getPath());
        for (String line : lines) {
            orders.add(Order.parseOrder(line));
        }
        return orders;
    }

    public void renderOder() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(ORDER_PATH.getPath()));
            while ((line = br.readLine()) != null) {
                printMenu(parseCsvLine(line));
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

    public static void printMenu(List<String> orderList) {
        System.out.printf("%s, %s, %s, %s, %s\n", orderList.get(0), orderList.get(1), orderList.get(2), orderList.get(3),
                orderList.get(4));
    }


    public void addOrder(Order order) {
        List<Order> orderList = findAll();
        orderList.add(order);
        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), orderList);
    }

}
