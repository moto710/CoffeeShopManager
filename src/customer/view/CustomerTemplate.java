package customer.view;

import customer.Customer;
import customer.CustomerManagement;
import product.Product;
import product.ProductManagement;
import viewtemplate.ViewTemplate;

import java.util.Comparator;
import java.util.List;

public abstract class CustomerTemplate extends ViewTemplate {
    protected static CustomerManagement customerManagement;

    protected Comparator<Customer> comparator;
    protected CustomerTemplate(){
        customerManagement = new CustomerManagement();
    }
    public static void showCustomer(List<Customer> customerList){
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }
}
