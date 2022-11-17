package views.user.functionview;

import models.User;
import viewtemplate.UserTemplate;

public class RemoveUserView extends UserTemplate {
    public RemoveUserView(){

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            System.out.println("Please enter views.user's ID to remove:");
            Long id = Long.parseLong(scanner.nextLine());
            User temp = userService.searchId(id);
            if (temp == null) {
                        System.out.println("The views.user with ID = " + id + " does not exist!");
                        flag = true;
                    } else {
                        System.out.println("Are you sure to remove this views.user? (Y/N)");
                        String comfirm = scanner.nextLine().toLowerCase();
                        switch (comfirm) {
                            case "Y":
                            case "y":
                                userService.removeUser(id);
                                break;
                            case "N":
                            case "n":
                                break;
                            default:
                                System.out.println("Try again!!");
                                break;
                        }
                    }
        } while (flag);
    }
}
