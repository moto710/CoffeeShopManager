package customer.view.functionview.allsortview;

import customer.Customer;
import customer.sort.CompareCustomerDateCreate;
import customer.sort.CompareCustomerEmail;
import customer.view.CustomerTemplate;

import java.util.Collections;
import java.util.List;

public class SortCustomerByDateCreateAscView extends CustomerTemplate {
    public SortCustomerByDateCreateAscView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerDateCreate();
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        showCustomer(customers);
    }
}
