package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

public class SearchUserByEmailView extends UserTemplate {
    public SearchUserByEmailView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter views.user's email to search:");
        String email = scanner.nextLine();
        User temp = userManagement.searchEmail(email);

        if (temp == null) {
            System.out.println("The views.user with name \"" + email + "\" does not exist!");
        } else {
            System.out.println(temp);
        }
    }
}
