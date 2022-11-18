package views;

import views.login.AllAdminManage;
import views.orderitem.*;
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
                        ShowAllOrderItem showAllOrderItem = new ShowAllOrderItem();
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
                        AllAdminManage allAdminManage = new AllAdminManage();
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
        System.out.println("================= ORDER ITEM ===================");
        System.out.println("=                                              =");
        System.out.println("=           1. Show all order item             =");
        System.out.println("=           2. Add one order item              =");
        System.out.println("=           3. Edit a order item               =");
        System.out.println("=           4. Remove order item               =");
        System.out.println("=           0. Exit!                           =");
        System.out.println("=                                              =");
        System.out.println("================================================");
        System.out.println("Choose function to show!");
        System.out.print("===>");
    }
}
