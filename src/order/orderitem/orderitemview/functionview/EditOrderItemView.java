package order.orderitem.orderitemview.functionview;

import order.orderitem.OrderItem;
import order.orderitem.orderitemview.OrderItemTemplate;
import product.Product;

public class EditOrderItemView extends OrderItemTemplate {
    public EditOrderItemView() {

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        OrderItem needEdit;
        long id = 0;

        do {
            try{
                System.out.println("Enter order item's ID to edit:");
                id = Long.parseLong(scanner.nextLine());

                needEdit = orderItemManagement.findIdOrderItem(id);
                if (needEdit == null) {
                    System.out.println("Can not find order item with ID = " + id);
                    flag = true;
                } else {
                    System.out.println(needEdit);
                    flag = false;
                }
            }catch(NumberFormatException n){
                System.err.println("Wrong ID, try again!");
                flag = true;
                scanner.reset();
            }
        } while(flag);


        do {
            try {
                menuEdit();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter new product's ID to change:");
                        String name = scanner.nextLine();
                        orderItemManagement.editOrderItemProduct(id, name);
                        break;
                    case 2:
                        do {
                            try {
                                System.out.println("Enter new item's quantity:");
                                orderItemManagement.editOrderItemQuantity(id, Float.parseFloat(scanner.nextLine()));
                                flag = false;
                            } catch (Exception e) {
                                System.err.println("You must enter a number!");
                                flag = true;
                                scanner.reset();
                            }
                        } while (flag);
                        break;
                    case 0:
                        System.out.println("Exit!");
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong input, enter again!");
                        flag = true;
                        break;
                }
            } catch (Exception e) {
                System.err.println("Wrong input, try again, bae!");
                flag = true;
                scanner.reset();
            }
        } while (flag);
    }
    public void menuEdit() {
        System.out.println("What part of order item do you want to edit?");
        System.out.println("1. Product:");
        System.out.println("2. Quantity:");
        System.out.println("0. Exit!");
    }
}
