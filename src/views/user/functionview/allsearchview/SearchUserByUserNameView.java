package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

import static views.login.view.allloginview.ShowUsersView.printUser;

public class SearchUserByUserNameView extends UserTemplate {
    public SearchUserByUserNameView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter user's user name to search:");
        String userName = scanner.nextLine();
        User user = userService.searchUserName(userName);

        if (user == null) {
            System.out.println("The user with user name \"" + userName + "\" does not exist!");
        } else {
            printUser(user);
        }
    }
}
