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
            User temp = new User();
            if (user.getUserName().equals(userName)) {
                temp = user;

                System.out.println("Enter your email");
                System.out.printf("===>");
                String email = scanner.nextLine();

                System.out.println("Enter your phone");
                System.out.printf("===>");
                String phone = scanner.nextLine();

                if(temp.getPhone().equals(phone) && temp.getEmail().equals(email)){
                    System.out.println("Your password: " + temp.getPassword());
                } else {
                    System.out.println("Invalid information, try again!!!");
                    break;
                }
            }else {
                System.out.println("This account does not exist!!!");
            }
        }
    }
}
