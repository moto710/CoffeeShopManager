package viewtemplate;

import models.Customer;
import service.CustomerService;
import viewtemplate.ViewTemplate;

import java.util.Comparator;
import java.util.List;

public abstract class CustomerTemplate extends ViewTemplate {
    protected static CustomerService customerManagement;

    protected Comparator<Customer> comparator;
    protected CustomerTemplate(){
        customerManagement = new CustomerService();
    }
    public static void showCustomer(List<Customer> customerList){
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }
}
