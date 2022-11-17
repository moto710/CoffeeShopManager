package views;

import models.User;
import views.user.functionview.*;
import viewtemplate.UserTemplate;
import views.user.view.functionview.*;

import java.util.List;

public class UserView extends UserTemplate {
    public UserView(){

    }
    @Override
    protected void showBody() {
        boolean flag = true;
        List<User> userList = userManagement.findAll();

        do {
            try {
                menuProductView();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        userManagement.renderUser();
                        break;
                    case 2:
                        CreateNewUserView createNewUserView = new CreateNewUserView();
                        break;
                    case 3:
                        EditUserView editProductView = new EditUserView();
                        break;
                    case 4:
                        RemoveUserView removeProductView = new RemoveUserView();
                        break;
                    case 5:
                        SearchUserView searchProductView = new SearchUserView();
                        break;
                    case 6:
                        SortUserView sortProductView = new SortUserView();
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong input, try again!");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Wrong input, try again!!!!!");
            }
        } while (flag == true);
    }
    public void menuProductView() {
        System.out.println("Choose views.user's function to show:\n");
        System.out.println("1. Show all views.user:");
        System.out.println("2. Add one views.user:");
        System.out.println("3. Edit a views.user:");
        System.out.println("4. Remove a views.user:");
        System.out.println("5. Search views.user:");
        System.out.println("6. Sort views.user list:");
        System.out.println("0. Exit!");
    }
}