package views;

import views.customer.functionview.*;
import viewtemplate.CustomerTemplate;

public class CustomerView extends CustomerTemplate {
    public CustomerView(){

    }
    @Override
    protected void showBody() {
        boolean flag = true;
        do {
            try {
                menuCustomerView();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        customerManagement.renderCustomer();
                        break;
                    case 2:
                        AddCustomerView addProductView = new AddCustomerView();
                        break;
                    case 3:
                        EditCustomerView editProductView = new EditCustomerView();
                        break;
                    case 4:
                        RemoveCustomerView removeProductView = new RemoveCustomerView();
                        break;
                    case 5:
                        SearchCustomerView searchProductView = new SearchCustomerView();
                        break;
                    case 6:
                        SortCustomerView sortProductView = new SortCustomerView();
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
    public void menuCustomerView() {
        System.out.println("Choose views.product's function to show:\n");
        System.out.println("1. Show all customers:");
        System.out.println("2. Add one views.customer:");
        System.out.println("3. Edit a views.customer:");
        System.out.println("4. Remove a views.customer:");
        System.out.println("5. Search views.customer:");
        System.out.println("6. Sort customers list:");
        System.out.println("0. Exit!");
    }
}
