package views.customer.functionview.allsearchview;

import viewtemplate.CustomerTemplate;

public class SearchCustomerByIdView extends CustomerTemplate {
    public SearchCustomerByIdView() {

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            try {
                System.out.println("Enter views.customer's ID to search:");
                long id = Long.parseLong(scanner.nextLine());
                if (customerManagement.searchId(id) == null) {
                    System.out.printf("Customer with ID \"%s\" does not exist!!!\n", id);
                    break;
                }else {
                    System.out.println(customerManagement.searchId(id));
                }
            } catch (NumberFormatException numberFormatException) {
                System.err.println("Invalid input, re-enter!");
                flag = true;
            }
        } while (flag);
    }
}
