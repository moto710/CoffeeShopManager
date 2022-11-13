package login;

import login.view.allloginview.*;
import login.view.LoginTemplate;
import user.view.functionview.CreateNewUserView;

public class LoginView extends LoginTemplate {
    public LoginView() {

    }

    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    CheckLoginView checkLoginView = new CheckLoginView();
                    break;
                case 2:
                    CreateNewUserView createNewUser = new CreateNewUserView();
                    break;
                case 3:
                    PasswordFogotView passwordFogotView = new PasswordFogotView();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    flag = true;
                    break;
            }
        }while (flag);
        menuLogin();

    }
    public void menuLogin() {
        System.out.println("************************************************");
        System.out.println("");
        System.out.println("\t\tHello! Choose a function:");
        System.out.println("");
        System.out.println("\t\t1. Login");
        System.out.println("\t\t2. Create Account");
        System.out.println("\t\t3. Fogot Password");
        System.out.println("\t\t0. Exit!");
        System.out.println("");
        System.out.println("*************************************************");
    }
}

