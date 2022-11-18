package views.login.view.allloginview;

import views.login.AdminView;
import views.login.AllAdminManage;
import views.login.view.LoginTemplate;
import service.UserService;
import models.User;

import java.util.List;

public class CheckLoginView extends LoginTemplate {
    public CheckLoginView() {
    }

    @Override
    protected void showBody() {
        List<User> userList = UserService.findAll();
        boolean flag = false;
        do {
            System.out.println("Enter your user name:");
            String userName = scanner.nextLine();

            System.out.println("Enter your Password:");
            String password = scanner.nextLine();

            for (User user : userList) {
                String checkUser = user.getUserName();
                String checkPassword = user.getPassword();
                String checkRole = user.getRoleAccount().getValue();

                if (checkUser.equals(userName) && checkPassword.equals(password)) {
                    if (checkRole.equals("ADMIN")) {
                        System.out.println("Welcome back, admin!");
                        System.out.println("Hello " + user.getFullName());
                        AllAdminManage allAdminManage = new AllAdminManage();

//                        AdminView adminView = new AdminView();
                        flag = false;
                        break;
                    }
                    if (checkRole.equals("USER")) {
                        break;
                    }
                }else {
                    System.out.println("Something wrong! Try again");
                    flag = true;
                }
            }
        } while (flag);
    }
}
