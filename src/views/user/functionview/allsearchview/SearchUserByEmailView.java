package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

import static views.login.view.allloginview.ShowUsersView.printUser;

public class SearchUserByEmailView extends UserTemplate {
    public SearchUserByEmailView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter user's email to search:");
        String email = scanner.nextLine();
        User temp = userService.searchEmail(email);

        if (temp == null) {
            System.out.println("The user with name \"" + email + "\" does not exist!");
        } else {
            printUser(temp);
        }
    }
}
