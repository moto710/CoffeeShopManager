package views.customer.sort;

import models.Customer;

import java.util.Comparator;

public class CompareCustomerId implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return (int) (o1.getIdCustomer() - o2.getIdCustomer());
    }
}
