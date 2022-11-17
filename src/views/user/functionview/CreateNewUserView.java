package views.user.functionview;

import models.User;
import viewtemplate.UserTemplate;

import java.util.List;

import static utils.ValidateUtils.*;
import static utils.ValidateUtils.isNameValid;
import static views.login.view.allloginview.ShowUsersView.printUser;

public class CreateNewUserView extends UserTemplate {
    public CreateNewUserView() {

    }

    @Override
    protected void showBody() {
        List<User> users = userService.findAll();

        System.out.println("Create new user:");
        System.out.println("----------------");

        String userName;
        do {
            System.out.println("Enter new user's user name (Upper case first letter)");
            userName = scanner.nextLine();
        } while (!isUserNameValid(userName));

        String password;
        do {
            System.out.println("Enter new user's password (At least one upper case, one number, one special character, more than 6 characters)");
            password = scanner.nextLine();
        } while (!isPasswordValid(password));

        String fullName;
        do {
            System.out.println("Enter new user's full name (Upper case first letter)");
            fullName = scanner.nextLine();
        } while (!isNameValid(fullName));

        String phone;
        do {
            System.out.println("Enter new user's phone number:");
            phone = scanner.nextLine();
        } while (!isPhoneValid(phone));

        String email;
        do {
            System.out.println("Enter new user's email:");
            email = scanner.nextLine();
        } while (!isEmailValid(email));

        String address;
        do {
            System.out.println("Enter new user's address:");
            address = scanner.nextLine();
        } while (!isNameValid(address));

        User newUser = new User(userName, password, fullName, phone, email, address);
        userService.addUser(newUser);
        printUser(newUser);
        ;
    }
}
