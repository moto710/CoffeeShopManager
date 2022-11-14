package login.view.allloginview;

import login.view.LoginTemplate;
import user.view.functionview.CreateNewUserView;

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
                case 1: //login
                    CheckLoginView checkLogin = new CheckLoginView();
                    break;
                case 2: //create account
                    CreateNewUserView createNewUserView = new CreateNewUserView();
                    break;
                case 3: //forget password
                    PasswordFogotView passwordFogotView = new PasswordFogotView();
                    break;
                case 4: //exit
                    break;
            }
        } while (flag);

//        while (!choice.equals("0")  && !choice.equals("1") && !choice.equals("2")  && !choice.equals("3") && choice.equals("-2") ) {
//
//            switch (choice) {
//                case "1":
//                    CheckLogin checklogin = new CheckLogin();
//                    checklogin.checkLogin();
//                    break;
//                case "2":
//                    CreateUserManager createUserManager = new CreateUserManager();
//                    createUserManager.createAddUser();
//                    System.out.println("Nhấn 1 để về menu Login hoặc 0 để thoát!");
//                    System.out.printf("︻┳═一 :");
//                    choice = input.nextLine();
//                    switch (choice) {
//                        case "1":
//                            login();
//                            break;
//                        case "0":
//                            System.out.println("Hẹn Gặp Lại!!!");
//                            System.exit(0);
//                            break;
//                        default:
//                            System.out.println("Vui Lòng Nhập Lại!!");
//                            System.out.println("Nhấn 1 để về menu Login hoặc 0 để thoát!");
//                            System.out.printf("︻┳═一 : ");
//                            choice = input.nextLine();
//                    }
//                    break;
//                case "3":
//                    PasswordFogot passwordFogot = new PasswordFogot();
//                    passwordFogot.CheckEmail();
//                    System.out.println("Nhấn 1 để về menu Login hoặc 0 để thoát!");
//                    System.out.printf("︻┳═一 :");
//                    choice = input.nextLine();
//                    switch (choice) {
//                        case "1":
//                            login();
//                            break;
//                        case "0":
//                            System.out.println("Hẹn Gặp Lại!!!");
//                            System.exit(0);
//                            break;
//                        default:
//                            System.out.println("Vui Lòng Nhập Lại!!");
//                            System.out.println("Nhấn 1 để về menu Login hoặc 0 để thoát!");
//                            System.out.printf("︻┳═一 : ");
//                            choice = input.nextLine();
//                    }
//                    break;
//                case "0":
//                    System.out.println("Hẹn Gặp Lại!!!");
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Không đúng định dạng, Vui Lòng Nhập Lại!!");
//                    login();
//            }
//        }
    }

    private void menuLogin() {
        System.out.println("***********************************************");
        System.out.println("*                                             *");
        System.out.println("*         Welcome to MT's Coffee Shop         *");
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
