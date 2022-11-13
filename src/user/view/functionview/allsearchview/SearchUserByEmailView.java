package user.view.functionview.allsearchview;

import user.User;
import user.view.UserTemplate;

public class SearchUserByEmailView extends UserTemplate {
    public SearchUserByEmailView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter user's email to search:");
        String email = scanner.nextLine();
        User temp = userManagement.searchEmail(email);

        if (temp == null) {
            System.out.println("The user with name \"" + email + "\" does not exist!");
        } else {
            System.out.println(temp);
        }
    }
}
