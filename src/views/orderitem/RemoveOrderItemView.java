package views.orderitem;

import models.OrderItem;
import viewtemplate.OrderItemTemplate;


import static service.OrderItemService.*;

public class RemoveOrderItemView extends OrderItemTemplate {
    public RemoveOrderItemView() {

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            System.out.println("Please enter order item's ID to remove:");
            long id = Long.parseLong(scanner.nextLine());
            OrderItem temp = findIdOrderItem(id);

            if (temp.getIdOrderItem() == -1) {
                System.out.println("The order item with id = " + id + " does not exist!");
                flag = true;
            } else {
                System.out.println("Are you sure to remove this order item? (Y/N)");
                String confirm = scanner.nextLine();
                switch (confirm) {
                    case "Y":
                    case "y":
                        removeOrderItem(id);
                        System.out.println("Remove order item success!");
                        break;
                    case "N":
                    case "n":
                        break;
                    default:
                        System.out.println("Try again!!");
                        break;
                }
            }
        } while (flag);
    }
}
