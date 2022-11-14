package customer.view.functionview.allsearchview;

import customer.Customer;
import customer.view.CustomerTemplate;

import java.util.List;

public class SearchCustomerByEmailView extends CustomerTemplate {
    public SearchCustomerByEmailView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Enter customer's email to search:");
        String email = scanner.nextLine();
        Customer temp = customerManagement.searchEmail(email);
        System.out.println(temp);
    }
}
