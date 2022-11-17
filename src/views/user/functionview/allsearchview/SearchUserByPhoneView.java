package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

import static views.login.view.allloginview.ShowUsersView.printUser;

public class SearchUserByPhoneView extends UserTemplate {
    public SearchUserByPhoneView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter user's phone number to search:");
        String phone = scanner.nextLine();
        User temp = userService.searchPhone(phone);

        if (temp == null) {
            System.out.println("The user with name \"" + phone + "\" does not exist!");
        } else {
            printUser(temp);
        }
    }
}
