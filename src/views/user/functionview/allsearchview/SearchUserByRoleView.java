package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

import java.util.List;

public class SearchUserByRoleView extends UserTemplate {
    public SearchUserByRoleView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter views.user's role to search:");
        String role = scanner.nextLine();
        List<User> list = userManagement.searchRole(role);

        if (list == null) {
            System.out.println("Wrong input:" + role);
        } else {
            showUser(list);
        }
    }
}
