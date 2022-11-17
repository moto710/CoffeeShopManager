package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

import java.util.List;

public class SearchUserByPasswordView extends UserTemplate {
    public SearchUserByPasswordView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter views.user's password to search:");
        String password = scanner.nextLine();
        List<User> list = userManagement.searchPassword(password);

        if (list == null) {
            System.out.println("The views.user with password \"" + password + "\" does not exist!");
        } else {
            showUser(list);
        }
    }
}
