package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

import java.util.List;

public class SearchUserByNameView extends UserTemplate {
    public SearchUserByNameView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter views.user's name to search:");
        String name = scanner.nextLine();
        List<User> list = userManagement.searchName(name);

        if (list == null) {
            System.out.println("The views.user with name \"" + name + "\" does not exist!");
        } else {
            showUser(list);
        }
    }
}
