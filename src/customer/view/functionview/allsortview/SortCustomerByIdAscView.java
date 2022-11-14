package customer.view.functionview.allsortview;

import customer.Customer;
import customer.sort.CompareCustomerId;
import customer.view.CustomerTemplate;
import product.Product;
import product.sort.ComparatorById;

import java.util.Collections;
import java.util.List;

public class SortCustomerByIdAscView extends CustomerTemplate {
    public SortCustomerByIdAscView() {

    }
    @Override
    protected void showBody() {
        comparator = new CompareCustomerId();
        List<Customer> customers = customerManagement.findAll();
        Collections.sort(customers, comparator);
        showCustomer(customers);
    }
}
