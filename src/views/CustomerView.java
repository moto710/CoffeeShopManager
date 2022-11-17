package views;

import views.customer.functionview.*;
import views.login.AllAdminManage;
import viewtemplate.CustomerTemplate;

public class CustomerView extends CustomerTemplate {
    public CustomerView(){

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            try {
                menuCustomerView();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        ShowAllCustomerView showAllCustomerView = new ShowAllCustomerView();
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
                        AllAdminManage allAdminManage = new AllAdminManage();
                        break;
                    default:
                        System.out.println("Wrong input, try again!");
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.err.println("Wrong input, try again!!!!!");
                flag = true;
                e.printStackTrace();
            }
        } while (flag);

    }
    public void menuCustomerView() {
        System.out.println("================= Choose product's function to show ===================");
        System.out.println("=                                                                     =");
        System.out.println("=                      1. Show all customers                          =");
        System.out.println("=                      2. Add one customer                            =");
        System.out.println("=                      3. Edit a customer                             =");
        System.out.println("=                      4. Remove a customer                           =");
        System.out.println("=                      5. Search customer                             =");
        System.out.println("=                      6. Sort customers list                         =");
        System.out.println("=                      0. Exit!                                       =");
        System.out.println("=                                                                     =");
        System.out.println("=======================================================================");
        System.out.println("Choose function to show!");
        System.out.print("===>");
    }
}
