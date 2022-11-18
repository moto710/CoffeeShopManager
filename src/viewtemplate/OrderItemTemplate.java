package viewtemplate;

import models.OrderItem;
import service.OrderItemService;

import java.util.Comparator;
import java.util.List;

import static service.OrderItemService.countGrandTotal;

public abstract class OrderItemTemplate extends ViewTemplate {
    protected static OrderItemService orderItemManagement;

    protected Comparator<OrderItem> comparator;

    protected OrderItemTemplate() {
        orderItemManagement = new OrderItemService();
    }

    public static void showOrderItemList(List<OrderItem> orderItemList) {
        System.out.println("=========================================== ORDER ITEM LIST ========================================================\n");
        System.out.printf("|%-12s| |%-12s| | %-18s |  | %-16s |  \n", "ID", "ID Product", "Quantity", "Total" , "\n");
        for (OrderItem item : orderItemList) {
            System.out.printf("|%-12s| |%-12s| | %-18s |  | %-16s |  \n", item.getIdOrderItem(), item.getIdProduct(), item.getQuantity(), item.getTotal());
        }
        System.out.println("\n========================================== Grand Total: " + countGrandTotal() + "==============================================");
    }

    public static void showOrderItem(OrderItem orderItem) {
        System.out.println("========================================================================= ORDER ITEM LIST ============================================================================\n");
        System.out.printf("|%-12s| |%-12s| | %-18s |  | %-16s | \n", "ID", "ID Product", "Quantity", "Total" + "\n");
        System.out.printf("|%-12s| |%-12s| | %-18s |  | %-16s | \n", orderItem.getIdOrderItem(), orderItem.getIdProduct(), orderItem.getQuantity(), orderItem.getTotal());
        System.out.println("======================================================================================================================================================================");
    }
}
