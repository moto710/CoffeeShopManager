package views;

import views.order.functionview.AddOrderItemView;
import views.order.functionview.EditOrderItemView;
import views.order.functionview.RemoveOrderItemView;
import views.order.orderitem.orderitemview.functionview.*;
import viewtemplate.OrderItemTemplate;

public class OrderItemView extends OrderItemTemplate {
    public OrderItemView() {

    }
    @Override
    protected void showBody() {
        boolean flag = true;
        do {
            try {
                menuView();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        orderItemManagement.renderOrderItem();
                        break;
                    case 2:
                        AddOrderItemView addOrderItemView = new AddOrderItemView();
                        break;
                    case 3:
                        EditOrderItemView editOrderItemView = new EditOrderItemView();
                        break;
                    case 4:
                        RemoveOrderItemView removeOrderItemView = new RemoveOrderItemView();
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong input, try again!");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Wrong input, try again!!!!!");
                e.printStackTrace();
            }
        } while (flag == true);
    }
    public void menuView() {
        System.out.println("Choose views.product's function to show:\n");
        System.out.println("1. Show all views.order item:");
        System.out.println("2. Add one views.order item:");
        System.out.println("3. Edit a views.order item:");
        System.out.println("4. Remove a views.order item:");
        System.out.println("0. Exit!");
    }
}
