package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

public class SearchUserByPhoneView extends UserTemplate {
    public SearchUserByPhoneView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter views.user's phone number to search:");
        String phone = scanner.nextLine();
        User temp = userManagement.searchPhone(phone);

        if (temp == null) {
            System.out.println("The views.user with name \"" + phone + "\" does not exist!");
        } else {
            System.out.println(temp);
        }
    }
}
