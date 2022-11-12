package utils;

import order.AllOrderManager;
import order.OrderItemManager;
import order.OrderManager;
import order.AllOrder;
import order.Order;
import order.OrderItem;

import java.time.Instant;
import java.util.List;

public class AddOrderItemInAllOrder {
    private final static String PATCH_ALLORDER = "D:\\vscode\\module2\\CSModule2\\CSModule2\\data\\AllOrder.csv";
   public void AddOrderItemInAllOrder(){
       List<OrderItem> orderItemList = OrderItemManager.findAll();
       List<Order> orderList = OrderManager.findAll();
       for(Order order: orderList) {
           for (OrderItem orderitem : orderItemList) {
               Instant createAt = Instant.now();
               List<AllOrder> allOrders = AllOrderManager.findAll();
               AllOrder allOrder = new AllOrder(order.getId(),order.getFullName(),order.getPhone(),order.getAddress(),orderitem.getId(), orderitem.getNameFood(), orderitem.getPrice(), orderitem.getQuantity(), orderitem.getTotal(), createAt);
               allOrders.add(allOrder);
               ReadWriteFile.write(PATCH_ALLORDER, allOrders);
           }
       }
    }
}
