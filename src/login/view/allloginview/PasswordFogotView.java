package login.view.allloginview;

import login.view.LoginTemplate;
import user.UserManagement;
import user.User;

import java.util.List;

public class PasswordFogotView extends LoginTemplate {
    public PasswordFogotView(){

    }
        @Override
    protected void showBody() {
        List<User> userList = UserManagement.findAll();
        System.out.println("Enter your user name");
        System.out.printf("===>");
        String userName = scanner.nextLine();

        for(User user: userList){
            String checkUser = user.getUserName();
            String checkPhone = user.getPhone();
            String checkEmail = user.getEmail();

            if(checkUser.equals(userName)){
                System.out.println("Enter your email");
                System.out.printf("===>");
                String email = scanner.nextLine();

                System.out.println("Enter your phone");
                System.out.printf("===>");
                String phone = scanner.nextLine();

                if(checkPhone.equals(phone) && checkEmail.equals(email)){
                    System.out.println("Your password: " + user.getPassword());
                } else {
                    System.out.println("Invalid information, try again!!!");
                    break;
                }
            }else {
                System.out.println("This account does now exist!!!");
            }
        }
    }
}
