package viewtemplate;

import models.Customer;
import service.CustomerService;

import java.util.Comparator;
import java.util.List;

public abstract class CustomerTemplate extends ViewTemplate {
    protected static CustomerService customerManagement;

    protected Comparator<Customer> comparator;

    protected CustomerTemplate() {
        customerManagement = new CustomerService();
    }

    public static void showCustomerList(List<Customer> customerList) {
        System.out.println("========================================================================= CUSTOMER LIST ====================================================================================\n");
        System.out.printf("|%-12s| | %-18s |  | %-16s | %-20s | %-15s |  | %-20s |  | %-20s |\n", "ID", "Name", "Email", "Address", "Phone Number", "Date Create", "Date Update" + "\n");
        for (Customer customer : customerList) {
            System.out.printf("|%-12s| | %-18s |  | %-16s | %-20s | %-15s |  | %-20s |  | %-20s |\n", customer.getIdCustomer(), customer.getFullName(), customer.getEmail(), customer.getAddress(), customer.getPhone(), customer.getDateCreate(), customer.getDateUpdate());
        }
        System.out.println("=========================================================================================================================================================================");
    }

    public static void showCustomer(Customer customer) {
        System.out.println("========================================================================= CUSTOMER ====================================================================================\n");
        System.out.printf("|%-12s| | %-18s |  | %-16s | %-20s | %-15s |  | %-20s |  | %-20s |\n", "ID", "Name", "Email", "Address", "Phone Number", "Date Create", "Date Update" + "\n");

        System.out.printf("|%-12s| | %-18s |  | %-16s | %-20s | %-15s |  | %-20s |  | %-20s |\n", customer.getIdCustomer(), customer.getFullName(), customer.getEmail(), customer.getAddress(), customer.getPhone(), customer.getDateCreate(), customer.getDateUpdate());

        System.out.println("=========================================================================================================================================================================");
    }
}
