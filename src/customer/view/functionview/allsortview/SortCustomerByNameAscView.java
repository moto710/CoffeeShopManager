package customer.view.functionview.allsortview;

import customer.Customer;
import customer.sort.CompareCustomerId;
import customer.sort.CompareCustomerName;
import customer.view.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByNameAscView extends CustomerTemplate {
    public SortCustomerByNameAscView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerName();
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        showCustomer(customers);
    }
}
