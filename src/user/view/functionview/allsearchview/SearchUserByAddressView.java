package user.view.functionview.allsearchview;

import user.User;
import user.view.UserTemplate;

import java.util.List;

public class SearchUserByAddressView extends UserTemplate {
    public SearchUserByAddressView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter user's address to search:");
        String address = scanner.nextLine();
        List<User> list = userManagement.searchAddress(address);

        if (list == null) {
            System.out.println("Don't have any user live in " + address);
        } else {
            showUser(list);
        }
    }
}
