package user.view.functionview;

import user.User;
import user.view.UserTemplate;

import java.util.Date;
import java.util.List;

public class CreateNewUserView extends UserTemplate {
    public CreateNewUserView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userManagement.findAll();

        System.out.println("Create new user:");
        System.out.println("----------------");

        System.out.println("Enter new user's user name:");
        String userName = scanner.nextLine();

        System.out.println("Enter new user's password:");
        String password = scanner.nextLine();

        System.out.println("Enter new user's full name:");
        String fullName = scanner.nextLine();

        System.out.println("Enter new user's phone number:");
        String phone = scanner.nextLine();

        System.out.println("Enter new user's email:");
        String email = scanner.nextLine();

        System.out.println("Enter new user's address:");
        String address = scanner.nextLine();

        Date dateCreate = new Date();
        Date dateUpdate = new Date();

        User newUser = new User(userName, password, fullName, phone, email, address);
        userManagement.addUser(newUser);

        System.out.println(newUser);;
    }
}
