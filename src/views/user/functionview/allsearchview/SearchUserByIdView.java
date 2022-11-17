package views.user.functionview.allsearchview;

import models.User;
import viewtemplate.UserTemplate;

import static views.login.view.allloginview.ShowUsersView.printUser;

public class SearchUserByIdView extends UserTemplate {
    public SearchUserByIdView() {

    }

    @Override
    protected void showBody() {
        boolean flag = false;
        long id;

        do {
            try {
                System.out.println("Enter user's ID to search:");
                id = Long.parseLong(scanner.nextLine());
                if (userService.searchId(id) == null) {
                    System.out.printf("User with ID \"%s\" does not exist!!!\n", id);
                    break;
                } else {
                    User user = userService.searchId(id);
                    printUser(user);
                }
            } catch (NumberFormatException numberFormatException) {
                System.err.println("Invalid input, re-enter!");
                flag = true;
            }
        } while (flag);
    }
}
