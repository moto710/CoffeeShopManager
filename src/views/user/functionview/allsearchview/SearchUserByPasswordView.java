package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

import java.util.List;

import static views.login.view.allloginview.ShowUsersView.showUserList;

public class SearchUserByPasswordView extends UserTemplate {
    public SearchUserByPasswordView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter user's password to search:");
        String password = scanner.nextLine();
        List<User> list = userService.searchPassword(password);
        if (list == null) {
            System.out.println("The user with password \"" + password + "\" does not exist!");
        } else {
            showUserList(list);
        }
    }
}
