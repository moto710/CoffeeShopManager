package views.customer.functionview;

import models.Customer;
import viewtemplate.CustomerTemplate;

public class EditCustomerView extends CustomerTemplate {
    public EditCustomerView() {

    }

    @Override
    protected void showBody() {
        boolean flag = false;
        Customer temp;
        long id = 0;

        do {
            try {
                System.out.println("Enter customer's ID to edit:");
                id = Long.parseLong(scanner.nextLine());

                temp = customerManagement.searchId(id);
                if (temp == null) {
                    System.out.println("Don't find customer with ID = " + id);
                    flag = true;
                } else {
                    System.out.println(temp);
                    flag = false;
                }
            } catch (NumberFormatException n) {
                System.err.println("Wrong ID, try again!");
                flag = true;
                scanner.reset();
            }
        } while (flag);


        do {
            try {
                menuEdit();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter new customer's name");
                        String name = scanner.nextLine();
                        customerManagement.editCustomerName(id, name);
                        System.out.println("Edit name success!");
                        break;
                    case 2:
                        System.out.println("Enter new customer's email:");
                        String email = scanner.nextLine();
                        customerManagement.editCustomerEmail(id, email);
                        System.out.println("Edit email success!");
                        break;
                    case 3:
                        System.out.println("Enter new customer's address:");
                        String address = scanner.nextLine();
                        customerManagement.editCustomerAddress(id, address);
                        System.out.println("Edit address success!");
                        break;
                    case 4:
                        System.out.println("Enter new customer's phone number:");
                        String phone = scanner.nextLine();
                        customerManagement.editCustomerPhone(id, phone);
                        System.out.println("Edit phone number success!");
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
        System.out.println("=========== What part of customer do you want to edit? =============");
        System.out.println("=                                                                  =");
        System.out.println("=                            1. Name                               =");
        System.out.println("=                            2. Email                              =");
        System.out.println("=                            3. Address                            =");
        System.out.println("=                            4. Phone                              =");
        System.out.println("=                            0. Exit!                              =");
        System.out.println("=                                                                  =");
        System.out.println("====================================================================");
        System.out.println("Choose function to show!");
        System.out.print("===>");
    }
}
