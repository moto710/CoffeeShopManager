package user.view.functionview;

import user.User;
import user.view.UserTemplate;

import java.util.List;

public class EditUserView extends UserTemplate {
    public EditUserView(){

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        User temp;
        long id = 0;

        do {
            try{
                System.out.println("Enter user's ID to edit:");
                id = Long.parseLong(scanner.nextLine());

                temp = userManagement.searchId(id);
                if (temp == null) {
                    System.out.println("Don't find user with ID = " + id);
                    flag = true;
                } else {
                    System.out.println(temp);
                    flag = false;
                }
            }catch(NumberFormatException n){
                System.err.println("Wrong ID, try again!");
                flag = true;
                scanner.reset();
            }
        } while(flag);


        do {
            try {
                menuEdit();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter new user's user name:");
                        String userName = scanner.nextLine();
                        userManagement.editUserUserName(id, userName);
                        break;
                    case 2:
                        System.out.println("Enter new user's password:");
                        String password = scanner.nextLine();
                        userManagement.editUserPassword(id, password);
                        break;
                    case 3:
                        System.out.println("Enter new user's full name:");
                        String fullName = scanner.nextLine();
                        userManagement.editUserFullName(id, fullName);
                        break;
                    case 4:
                        System.out.println("Enter new user's phone number:");
                        String phone = scanner.nextLine();
                        userManagement.editUserPhone(id, phone);
                        break;
                    case 5:
                        System.out.println("Enter new user's email:");
                        String email = scanner.nextLine();
                        userManagement.editUserEmail(id, email);
                        break;
                    case 6:
                        System.out.println("Enter new user's address:");
                        String address = scanner.nextLine();
                        userManagement.editUserAddress(id, address);
                        break;
                    case 0:
                        System.out.println("Exit!");
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong input, enter again!");
                        flag = true;
                        break;
                }
            } catch (Exception e) {
                System.err.println("Wrong input, try again!");
                flag = true;
                scanner.reset();
            }
        } while (flag);
    }
    public void menuEdit() {
        System.out.println("What part of user do you want to edit?");
        System.out.println("1. User name:");
        System.out.println("2. Password:");
        System.out.println("3. Full name:");
        System.out.println("4. phone");
        System.out.println("5. email:");
        System.out.println("6. address:");
    }
}
