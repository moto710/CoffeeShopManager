package customer.view.functionview;

import customer.Customer;
import customer.view.CustomerTemplate;
import product.Product;

public class RemoveCustomerView extends CustomerTemplate {
    public RemoveCustomerView() {

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            System.out.println("Please enter customer's id to remove:");
            Long id = Long.parseLong(scanner.nextLine());
            Customer temp = customerManagement.searchId(id);

            if (temp == null) {
                System.out.println("The customer with id = " + id + " does not exist!");
                flag = true;
            } else {
                System.out.println("Are you sure to remove this customer? (Y/N)");
                String comfirm = scanner.nextLine();
                switch (comfirm) {
                    case "Y":
                    case "y":
                        customerManagement.removeCustomer(id);
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
