package user.view.functionview.allsearchview;

import user.User;
import user.view.UserTemplate;

public class SearchUserByUserNameView extends UserTemplate {
    public SearchUserByUserNameView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter user's user name to search:");
        String userName = scanner.nextLine();
        User temp = userManagement.searchUserName(userName);

        if (temp == null) {
            System.out.println("The user with user name \"" + userName + "\" does not exist!");
        } else {
            System.out.println(temp);
        }
    }
}
