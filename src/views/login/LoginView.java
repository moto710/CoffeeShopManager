package views.login;

import views.login.view.allloginview.*;
import views.login.view.LoginTemplate;
import views.user.functionview.CreateNewUserView;

public class LoginView extends LoginTemplate {
    public LoginView() {

    }

    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            try {
                menuLogin();
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
            } catch (Exception e) {
                System.out.println("You must enter a number!");
                flag = true;
            }

        }while (flag);

    }
    public void menuLogin() {
        System.out.println("================= LOGIN ===================");
        System.out.println("=                                         =");
        System.out.println("=              1. Login                   =");
        System.out.println("=              2. Create Account          =");
        System.out.println("=              3. Forgot Password         =");
        System.out.println("=              0. Exit                    =");
        System.out.println("=                                         =");
        System.out.println("===========================================");
        System.out.println("Choose function to show!");
        System.out.print("===>");
    }
}

