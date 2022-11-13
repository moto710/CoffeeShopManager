package user.view.functionview.allsearchview;

import user.User;
import user.view.UserTemplate;

import java.util.List;

public class SearchUserByNameView extends UserTemplate {
    public SearchUserByNameView(){

    }
    @Override
    protected void showBody() {
        System.out.println("Enter user's name to search:");
        String name = scanner.nextLine();
        List<User> list = userManagement.searchName(name);

        if (list == null) {
            System.out.println("The user with name \"" + name + "\" does not exist!");
        } else {
            showUser(list);
        }
    }
}
