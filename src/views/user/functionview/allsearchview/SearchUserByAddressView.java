package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

import java.util.List;

import static views.login.view.allloginview.ShowUsersView.showUserList;

public class SearchUserByAddressView extends UserTemplate {
    public SearchUserByAddressView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter user's address to search:");
        String address = scanner.nextLine();
        List<User> list = userService.searchAddress(address);

        if (list == null) {
            System.out.println("Don't have any user live in " + address);
        } else {
            showUserList(list);
        }
    }
}
