package customer.view.functionview.allsearchview;

import customer.Customer;
import customer.view.CustomerTemplate;

public class SearchCustomerByPhoneView extends CustomerTemplate {
    public SearchCustomerByPhoneView() {

    }
    @Override
    protected void showBody() {
        System.out.println("Enter customer's phone number to search:");
        String phone = scanner.nextLine();
        Customer temp = customerManagement.searchPhone(phone);
        System.out.println(temp);
    }
}
