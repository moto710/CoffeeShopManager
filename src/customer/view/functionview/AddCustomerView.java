package customer.view.functionview;

import customer.Customer;
import customer.view.CustomerTemplate;

public class AddCustomerView extends CustomerTemplate {
    public AddCustomerView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Add new customer:");
        System.out.println("----------------");
        System.out.println("Enter new customer's full name:");
        String name = scanner.nextLine();

        System.out.println("Enter new customer's email:");
        String email = scanner.nextLine();

        System.out.println("Enter new customer's address:");
        String address = scanner.nextLine();

        System.out.println("Enter new customer's phone:");
        String phone = scanner.nextLine();

        Customer customer = new Customer(name, email, address, phone);
        customerManagement.addCustomer(customer);

        System.out.println(customer);
    }
}
