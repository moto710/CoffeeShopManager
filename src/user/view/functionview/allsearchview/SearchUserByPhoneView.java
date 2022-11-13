package user.view.functionview.allsearchview;

import user.User;
import user.view.UserTemplate;

public class SearchUserByPhoneView extends UserTemplate {
    public SearchUserByPhoneView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter user's phone number to search:");
        String phone = scanner.nextLine();
        User temp = userManagement.searchPhone(phone);

        if (temp == null) {
            System.out.println("The user with name \"" + phone + "\" does not exist!");
        } else {
            System.out.println(temp);
        }
    }
}
