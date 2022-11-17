package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

import java.util.List;

import static views.login.view.allloginview.ShowUsersView.showUserList;

public class SearchUserByRoleView extends UserTemplate {
    public SearchUserByRoleView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter user's role to search:");
        String role = scanner.nextLine();
        List<User> list = userService.searchRole(role);

        if (list == null) {
            System.out.println("Wrong input:" + role);
        } else {
            showUserList(list);
        }
    }
}
