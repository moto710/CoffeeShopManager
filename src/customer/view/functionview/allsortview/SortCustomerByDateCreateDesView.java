package customer.view.functionview.allsortview;

import customer.Customer;
import customer.sort.CompareCustomerDateCreate;
import customer.view.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByDateCreateDesView extends CustomerTemplate {
    public SortCustomerByDateCreateDesView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerDateCreate();
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        Collections.reverse(customers);
        showCustomer(customers);
    }
}
