package views;

import viewtemplate.CartTemplate;

public class CartView extends CartTemplate {
    public CartView() {

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
                        cartManagement.renderCart();
                        break;
                    case 2:
//                        AddCartView addCartView = new AddCartView();
                        break;
                    case 3:
//                        EditCartView editCartView = new EditCartView();
                        break;
                    case 4:
//                        RemoveCartView removeCartView = new RemoveCartView();
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
        System.out.println("Choose cart's function to show:\n");
        System.out.println("1. Show all cart:");
        System.out.println("2. Add one cart:");
        System.out.println("3. Edit a cart:");
        System.out.println("4. Remove a cart:");
        System.out.println("0. Exit!");
    }
}
