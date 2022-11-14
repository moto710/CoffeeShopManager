package customer.view.functionview.allsortview;

import customer.Customer;
import customer.sort.CompareCustomerEmail;
import customer.sort.CompareCustomerName;
import customer.view.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByEmailAscView extends CustomerTemplate {
    public SortCustomerByEmailAscView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerEmail();
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        showCustomer(customers);
    }
}
