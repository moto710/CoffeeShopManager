package order.orderitem;

import utils.ReadWriteFile;

import java.io.*;
import java.util.*;

import static enums.FilePath.ORDER_ITEM_PATH;


public class OrderItemManagement {
    private static List<OrderItem> orderItemList;

    public OrderItemManagement() {
        orderItemList = new ArrayList<>();
        this.orderItemList = orderItemList;
    }

    public static List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public static void setOrderItemList(List<OrderItem> orderItemList) {
        OrderItemManagement.orderItemList = orderItemList;
    }
    public static List<OrderItem> findAll() {
        List<OrderItem> orderItems = new ArrayList<>();
        List<String> lines = ReadWriteFile.read(ORDER_ITEM_PATH.getPath());
        for (String line : lines) {
            orderItems.add(OrderItem.parseOrderItem(line));
        }
        return orderItems;
    }
    public static void renderOrderItem() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(ORDER_ITEM_PATH.getPath()));
            while ((line = br.readLine()) != null) {
                printOrderItem(parseCsvLine(line));
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

    public static void printOrderItem(List<String> orderItems) {
        System.out.printf("%s, %s, %s, %s\n", orderItems.get(0), orderItems.get(1), orderItems.get(2),
                orderItems.get(3));
    }
    public static void addOrderItem(OrderItem orderItem) {
        List<OrderItem> orderItems = findAll();
        orderItems.add(orderItem);
        ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), orderItems);
    }
    public OrderItem findIdOrderItem(long id) {
        List<OrderItem> list = findAll();
        OrderItem temp = new OrderItem();
        for (OrderItem item : list) {
            if (item.getId() == id) {
                temp = item;
                break;
            }
        }
        return temp;
    }
    public void removeOrderItem(long id) {
        List<OrderItem> list = findAll();
        list.remove(findIdOrderItem(id));
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId() == id) {
//                list.remove(i);
//                break;
//            }
//        }
        ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), list);
    }

    public void editOrderItemQuantity(long id, float quantity) {
        List<OrderItem> list = findAll();
        for (OrderItem item : list) {
            if (item.getId() == id) {
                item.setQuantity(quantity);
                break;
            }
        }
        ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), list);
    }
}