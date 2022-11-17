package viewtemplate;

import models.OrderItem;
import service.OrderItemService;
import viewtemplate.ViewTemplate;

import java.util.Comparator;
import java.util.List;

public abstract class OrderItemTemplate extends ViewTemplate {
    protected static OrderItemService orderItemManagement;

    protected Comparator<OrderItem> comparator;
    protected OrderItemTemplate(){
        orderItemManagement = new OrderItemService();
    }
    public static void showOrderItem(List<OrderItem> orderItemList){
        for (OrderItem orderItem : orderItemList) {
            System.out.println(orderItem.toString());
        }
    }
}
