package order.orderitem;

import order.orderitem.OrderItem;
import product.*;
import utils.*;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

import static enums.FilePath.PRODUCT_LIST_PATH;
import static enums.FilePath.ORDER_ITEM_PATH;


public class OrderItemManager {
    List<OrderItem> orderItems;
    public OrderItemManager() {
        List<OrderItem> orderItemList = new ArrayList<>();
    }

    public static List<OrderItem> findAll() {
        List<OrderItem> orderItems = new ArrayList<>();
        List<String> lines = ReadWriteFile.read(ORDER_ITEM_PATH.getPath());
        for (String line : lines) {
            orderItems.add(OrderItem.parseOrderItem(line));
        }
        return orderItems;
    }

    public void addOrderItem() {
        List<OrderItem> orderItems = new ArrayList<>();
        List<Product> foods = ProductManagement.findAll();
        ProductManagement render = new ProductManagement();
        Scanner input = new Scanner(System.in);
        render.renderProduct();
        System.out.println("Nhập ID của món ăn muốn mua: ");
        Long id = Long.parseLong(input.nextLine());
        Double price = Double.valueOf(0);
        Double total = Double.valueOf(0);
        String nameFood = "";
        int count = 0;
        for (Product dish : foods) {
            Long tamp = dish.getId();
            if (tamp.equals(id)) {
                price = dish.getPrice();
                nameFood = dish.getName();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("ID Không tồn tại vui lòng nhập lại!!");
            addOrderItem();
            return;
        }
        double quantity = OrderValidateUltils.inputInventory();

        int countQuantity = 0;
        for (Product dish : foods) {
            double tampQuantity = dish.getInventory();
            Long tamp = dish.getId();
            if (tamp.equals(id) && tampQuantity >= quantity) {
                total = dish.getPrice() * quantity;
                dish.setInventory(dish.getInventory() - quantity);
                ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), foods);
                countQuantity++;
            }
        }
        if (countQuantity == 0) {
            System.out.println("Số lượng không đủ vui lòng nhập lại!!");
            addOrderItem();
            return;
        }
        OrderItem newOrder = new OrderItem(id, nameFood, price, (int) quantity, total);
        orderItems.add(newOrder);
        ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), orderItems);
        System.out.println("Order thành công!");
        renderOrderItem();
        System.out.println();
        System.out.println("Nhập y nếu muốn order tiếp hoặc p để in hóa đơn ");
        String choice = input.nextLine();
        switch (choice) {
            case "y":
                boolean tamp = true;
                while (tamp) {
                    System.out.println("Nhập y nếu muốn order tiếp ,Nhập e để sửa order, nhập d để xóa order hoặc p để in hóa đơn: ");
                    choice = input.nextLine();
                    switch (choice) {
                        case "y":
                            updateOrderItem();
                            tamp = true;
                            break;
                        case "e":
                            editOrderItem();
                            tamp = true;
                            break;
                        case "d":
                            deleteOrderItem();
                            tamp = true;
                            break;
                        case "p":
                            tamp = false;
                            break;
                        default:
                            System.out.println("Vui lòng nhập lại!!");
                            updateOrderItem();
                    }
                }
                break;
            case "p":
                break;
        }

    }

    public void updateOrderItem() {
        List<OrderItem> orderItems = findAll();
        List<Product> foods = ProductManagement.findAll();
        ProductManagement render = new ProductManagement();
        Scanner input = new Scanner(System.in);
        render.renderProduct();
        System.out.println("Nhập ID của món ăn muốn mua");
        Long id = Long.parseLong(input.nextLine());
        Double price = Double.valueOf(0);
        Double total = Double.valueOf(0);
        String nameFood = "";
        int count = 0;
        for (OrderItem orderItem : orderItems) {
            Long tampSame = orderItem.getId();
            if (tampSame.equals(id)) {
                List<OrderItem> orderItemList = findAll();
                price = orderItem.getPrice();
                nameFood = orderItem.getNameFood();
                count++;
                double quantityUpdate = OrderValidateUltils.inputInventory();
                int countQuantity = 0;
                if (orderItem.getId().equals(id))
                    orderItem.setQuantity((int) (orderItem.getQuantity() + quantityUpdate));
                total = orderItem.getPrice() * orderItem.getQuantity();
                for (Product dish : foods) {
                    double tampQuantity = dish.getInventory();
                    Long tampid = dish.getId();
                    if (tampid.equals(id) && tampQuantity >= quantityUpdate) {
                        dish.setInventory(dish.getInventory() - quantityUpdate);
                        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), foods);
                        countQuantity++;
                    }
                }
                if (countQuantity == 0) {
                    System.out.println("Số lượng không đủ vui lòng nhập lại!!");
                    updateOrderItem();
                    return;
                }
                orderItem.setQuantity(orderItem.getQuantity());
                orderItem.setNameFood(nameFood);
                orderItem.setPrice(price);
                orderItem.setTotal(total);
                ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), orderItems);
                renderOrderItem();
                System.out.println("Order thành công!");
                return;
            }
        }
        for (Product dish : foods) {
            Long tamp = dish.getId();
            if (tamp.equals(id)) {
                price = dish.getPrice();
                nameFood = dish.getName();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("ID không tồn tại vui lòng nhập lại!!");
            updateOrderItem();
            return;
        }
        double quantity = OrderValidateUltils.inputInventory();
        int countQuantity = 0;
        for (Product dish : foods) {
            double tampQuantity = dish.getInventory();
            Long tampid = dish.getId();
            if (tampid.equals(id) && tampQuantity >= quantity) {
                total = dish.getPrice() * quantity;
                dish.setInventory(dish.getInventory() - quantity);
                ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), foods);
                countQuantity++;
            }

        }
        if (countQuantity == 0) {
            System.out.println("Số lượng không đủ vui lòng nhập lại!!");
            updateOrderItem();
            return;
        }
        OrderItem newOrder = new OrderItem(id, nameFood, price, (int) quantity, total);
        orderItems.add(newOrder);
        ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), orderItems);
        renderOrderItem();
        System.out.println("Order thành công!");
    }

    public void renderOrderItem() {
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋ORDER-ITEMS㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
        System.out.printf("\n%-25s %-25s %-25s %-25s %-13s %s\n", "ID Product", "Tên Vật Phẩm", "Giá Tiền", "Số lượng", "Thành Tiền", "㊋");
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(ORDER_ITEM_PATH.getPath()));
            while ((line = br.readLine()) != null) {
                printMenuOrderItem(parseCsvLine(line));
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

    public static void printMenuOrderItem(List<String> OrderItem) {
        System.out.printf("\n%-25s %-25s %-25s %-25s %-13s %s\n", OrderItem.get(0), OrderItem.get(1), InstantUtils.doubleToVND(Double.parseDouble(OrderItem.get(2))), OrderItem.get(3), InstantUtils.doubleToVND(Double.parseDouble(OrderItem.get(4))), "㊋");
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

    public void editOrderItem() {

        Scanner input = new Scanner(System.in);
        List<OrderItem> orderItemList = findAll();
        List<Product> foods = ProductManagement.findAll();
        renderOrderItem();
        System.out.println();
        System.out.println("Nhập ID của vật phẩm muốn đổi: ");
        Long id = Long.parseLong(input.nextLine());
        for (OrderItem orderItem : orderItemList) {
            if(orderItem.getId().equals(id)){
                for (Product dish : foods) {
                    Long tampOldQuantity = dish.getId();
                    if (tampOldQuantity.equals(id)) {
                        dish.setInventory(dish.getInventory() + orderItem.getQuantity());
                        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), foods);
                    }
                }
            }
            }
        int count = 0;
        for (OrderItem orderItem : orderItemList) {
            Long tamp = orderItem.getId();
            String name = "";
            Double price = Double.valueOf(0);
            Double total = Double.valueOf(0);
            long idEdit = 0;
            int quantity = 0;
            if (tamp.equals(id)) {
                ProductManagement render = new ProductManagement();
                render.renderProduct();
                System.out.println("Nhập ID của vật phẩm mới: ");
                idEdit = Long.parseLong(input.nextLine());
                for (OrderItem orderItemEdit : orderItemList) {
                    Long tampSame = orderItemEdit.getId();
                    if (tampSame.equals(idEdit)) {
                        orderItemList.remove(orderItem);
                        List<OrderItem> orderItemListEdit = findAll();
                        price = orderItemEdit.getPrice();
                        name = orderItemEdit.getNameFood();
                        count++;
                        double quantityUpdate = OrderValidateUltils.inputInventory();
                        int countQuantity = 0;
                        if (orderItemEdit.getId().equals(idEdit))
                            orderItemEdit.setQuantity((int) (orderItemEdit.getQuantity() + quantityUpdate));
                        total = orderItemEdit.getPrice() * orderItemEdit.getQuantity();
                        for (Product dish : foods) {
                            double tampQuantity = dish.getInventory();
                            Long tampid = dish.getId();
                            if (tampid.equals(id) && tampQuantity >= quantityUpdate) {
                                dish.setInventory(dish.getInventory() - quantityUpdate);
                                ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), foods);
                                countQuantity++;
                            }
                        }
                        if (countQuantity == 0) {
                            System.out.println("Số lượng không đủ vui lòng nhập lại!!");
                            updateOrderItem();
                            return;
                        }

                        orderItemEdit.setQuantity(orderItemEdit.getQuantity());
                        orderItemEdit.setNameFood(name);
                        orderItemEdit.setPrice(price);
                        orderItemEdit.setTotal(total);
                        ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), orderItemList);
                        renderOrderItem();
                        System.out.println("Chỉnh sửa thành công!!");
                        return;
                    }
                }
                for (Product dish : foods) {
                    Long tampFood = dish.getId();
                    if (tampFood.equals(idEdit)) {
                        price = dish.getPrice();
                        name = dish.getName();
                    }
                }
                quantity = (int) OrderValidateUltils.inputInventory();
                for (Product dish : foods) {
                    Long tamp1 = dish.getId();
                    if (tamp1.equals(idEdit)) {
                        total = dish.getPrice() * quantity;
                        dish.setInventory(dish.getInventory() - quantity);
                        ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), foods);
                    }
                }
                orderItem.setId(idEdit);
                orderItem.setNameFood(name);
                orderItem.setPrice(price);
                orderItem.setQuantity(quantity);
                orderItem.setTotal(total);
                count++;

                ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), orderItemList);
                renderOrderItem();
                System.out.println("Chỉnh sửa thành công!!");
                break;
            }


        }

        if (count == 0) {
            System.out.println("ID không tồn tại vui lòng nhập lại!");
            editOrderItem();
        }
    }

    public void deleteOrderItem() {
        List<Product> foods = ProductManagement.findAll();
        Scanner input = new Scanner(System.in);
        List<OrderItem> orderItemList = findAll();
        renderOrderItem();
        System.out.println("Nhập ID của vật phẩm muốn xóa: ");
        Long id = Long.parseLong(input.nextLine());
        int count = 0;
        for (OrderItem orderItem : orderItemList) {
            Long tamp = orderItem.getId();
            if (tamp.equals(id)) {
                count++;
                System.out.println("Bạn có chắc chắn muốn xóa id " + id + ", nhấn y để xóa hoặc b để quay lại!");
                String choice = input.nextLine();
                switch (choice) {
                    case "y":
                        for (Product dish:foods ) {
                            Long tampOldDish = dish.getId();
                            if(tampOldDish.equals(id)){
                                dish.setInventory(dish.getInventory() + orderItem.getQuantity());
                                ReadWriteFile.write(PRODUCT_LIST_PATH.getPath(), foods);
                            }
                        }
                        orderItemList.remove(orderItem);
                        ReadWriteFile.write(ORDER_ITEM_PATH.getPath(), orderItemList);
                        renderOrderItem();
                        return;

                    case "b":
                        return;
                }
            }
        }
        if (count == 0) {
            System.out.println("ID không tồn tại vui lòng nhập lại !!");
            deleteOrderItem();
        }
    }

    public Double totalPrice() {
        List<OrderItem> orderItemList = findAll();
        Double totalPirce = Double.valueOf(0);
        for (OrderItem orderItem : orderItemList) {
            totalPirce += orderItem.getTotal();
        }
        return totalPirce;
    }
}