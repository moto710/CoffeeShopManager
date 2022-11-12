package login;

import login.view.allloginview.*;
import login.view.LoginTemplate;
import user.view.AddUserView;

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

//    public static void login() {
//        Scanner input = new Scanner(System.in);
//        while (!choice.equals("0")  && !choice.equals("1") && !choice.equals("2")  && !choice.equals("3") && choice.equals("-2") ) {

    //            System.out.println("Nhập lựa chọn của bạn: ");
//            System.out.printf("︻┳═一 :");
//            String choice = input.nextLine();
//            switch (choice) {
//                case "1":
//                    CheckLogin checklogin = new CheckLogin();
//                    checklogin.checkLogin();
//                    break;
//                case "2":
                    AddUserView createUserManager = new AddUserView();
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
//                   login();
//            }
//        }
//    }
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

