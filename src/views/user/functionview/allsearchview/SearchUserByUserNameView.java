package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

public class SearchUserByUserNameView extends UserTemplate {
    public SearchUserByUserNameView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter views.user's views.user name to search:");
        String userName = scanner.nextLine();
        User temp = userManagement.searchUserName(userName);

        if (temp == null) {
            System.out.println("The views.user with views.user name \"" + userName + "\" does not exist!");
        } else {
            System.out.println(temp);
        }
    }
}
