package customer.view.functionview.allsortview;

import customer.Customer;
import customer.sort.CompareCustomerId;
import customer.view.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByIdDesView extends CustomerTemplate {
    public SortCustomerByIdDesView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerId();
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        Collections.reverse(customers);
        showCustomer(customers);
    }
}
