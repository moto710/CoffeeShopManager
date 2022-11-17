package views.customer.sort;

import models.Customer;

import java.util.Comparator;

public class CompareCustomerDateCreate implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getDateCreate().compareTo(o2.getDateCreate());
    }
}
