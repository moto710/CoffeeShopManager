package views.orderitem;

import models.OrderItem;
import service.OrderItemService;
import viewtemplate.OrderItemTemplate;

import java.util.List;

public class ShowAllOrderItem extends OrderItemTemplate {
    @Override
    protected void showBody() {
        List<OrderItem> orderItems = OrderItemService.findAll();
        showOrderItemList(orderItems);
    }
}
