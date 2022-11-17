package views.login.view.allloginview;

import views.login.view.LoginTemplate;
import views.user.functionview.CreateNewUserView;

public class LoginView extends LoginTemplate {
    public LoginView() {
        showPage();
    }

    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            menuLogin();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: //views.login
                    CheckLoginView checkLogin = new CheckLoginView();
                    break;
                case 2: //create account
                    CreateNewUserView createNewUserView = new CreateNewUserView();
                    break;
                case 3: //forget password
                    PasswordForgotView passwordFogotView = new PasswordForgotView();
                    break;
                case 4: //exit
                    break;
            }
        } while (flag);
    }

    private void menuLogin() {
        System.out.println("***********************************************");
        System.out.println("                                               ");
        System.out.println("          Welcome to MT's Coffee Shop          ");
        System.out.println();
        System.out.println("\t1. Login");
        System.out.println("\t2. Create Account");
        System.out.println("\t3. Forget Password");
        System.out.println("\t0. Exit!");
        System.out.println();
        System.out.println("***********************************************");
        System.out.println("Enter your choice:");
        System.out.printf("===>");
    }
}
