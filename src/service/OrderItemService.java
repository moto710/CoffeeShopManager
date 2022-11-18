package service;

import models.OrderItem;
import utils.ReadWriteFile;

import java.io.*;
import java.util.*;

import static enums.FilePath.ORDER_ITEM_PATH;


public class OrderItemService {
    private static List<OrderItem> orderItemList;

    public OrderItemService() {
        orderItemList = new ArrayList<>();
        this.orderItemList = orderItemList;
    }

    public static List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public static void setOrderItemList(List<OrderItem> orderItemList) {
        OrderItemService.orderItemList = orderItemList;
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
    public static OrderItem findIdOrderItem(long id) {
        List<OrderItem> list = findAll();
        OrderItem temp = new OrderItem();
        for (OrderItem orderItem : list) {
            if (orderItem.getIdOrderItem() == id) {
                temp = orderItem;
                break;
            }
        }
        return temp;
    }
    public static void removeOrderItem(long id) {
        List<OrderItem> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdOrderItem() == id) {
                list.remove(i);
                break;
            }
        }
//        list.remove(findIdOrderItem(id));
        ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), list);
    }
    public static void removeOrderItem(OrderItem orderItem) {
        List<OrderItem> list = findAll();
        list.remove(orderItem);
        ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), list);
    }

    public void editOrderItemQuantity(long id, long quantity) {
        List<OrderItem> list = findAll();
        for (OrderItem item : list) {
            if (item.getIdOrderItem() == id) {
                item.setQuantity(quantity);
                break;
            }
        }
        ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), list);
    }

    public static long countGrandTotal() {
        List<OrderItem> orderItems = findAll();
        long grandTotal = 0;
        for (OrderItem item : orderItems) {
            grandTotal += item.getTotal();
        }
        return  grandTotal;
    }

//    public void swapOrderItemProduct(long idOrderItem, long idOtherProduct) {
//        List<OrderItem> list = findAll();
//        for (OrderItem item : list) {
//            if (item.getIdOrderItem() == idOrderItem) {
//                item.setProduct(productManagement.searchId(idOtherProduct));
//            }
//        }
//        ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), list);
//    }
}