package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

import java.util.List;

import static views.login.view.allloginview.ShowUsersView.showUserList;

public class SearchUserByNameView extends UserTemplate {
    public SearchUserByNameView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter user's name to search:");
        String name = scanner.nextLine();
        List<User> list = userService.searchName(name);

        if (list == null) {
            System.out.println("The user with name \"" + name + "\" does not exist!");
        } else {
            showUserList(list);
        }
    }
}
