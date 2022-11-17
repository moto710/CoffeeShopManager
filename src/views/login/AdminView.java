package views.login;

import models.User;
import views.user.functionview.*;
import viewtemplate.UserTemplate;

import java.util.List;

public class AdminView extends UserTemplate {
    public AdminView(){

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
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong input, try again!");
//                        flag = true;
                        break;
                }
            } catch (Exception e) {
                System.err.println("Wrong input, try again!!!!!");
//                flag = true;
            }
        } while (flag);
    }
    public void menuProductView() {
        System.out.println("================== ADMIN MANAGE ===================");
        System.out.println("=                                                 =");
        System.out.println("=               1. Show all user                  =");
        System.out.println("=               2. Add one user                   =");
        System.out.println("=               3. Edit a user                    =");
        System.out.println("=               4. Remove a user                  =");
        System.out.println("=               5. Search user                    =");
        System.out.println("=               6. Sort user list                 =");
        System.out.println("=               0. Exit!                          =");
        System.out.println("=                                                 =");
        System.out.println("===================================================");
        System.out.println("Choose function to show!");
        System.out.print("===>");
    }
}
