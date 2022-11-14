package order.orderitem.orderitemview;

import order.orderitem.OrderItem;
import order.orderitem.OrderItemManagement;
import viewtemplate.ViewTemplate;

import java.util.Comparator;
import java.util.List;

public abstract class OrderItemTemplate extends ViewTemplate {
    protected static OrderItemManagement orderItemManagement;

    protected Comparator<OrderItem> comparator;
    protected OrderItemTemplate(){
        orderItemManagement = new OrderItemManagement();
    }
    public static void showOrderItem(List<OrderItem> orderItemList){
        for (OrderItem orderItem : orderItemList) {
            System.out.println(orderItem.toString());
        }
    }
}
