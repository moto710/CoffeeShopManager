package user.view.functionview;

import product.Product;
import user.User;
import user.view.UserTemplate;

public class RemoveUserView extends UserTemplate {
    public RemoveUserView(){

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            System.out.println("Press 1 key to remove user or 0 to exit!");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Please enter user's IDto remove:");
                    Long id = Long.parseLong(scanner.nextLine());

                    User temp = userManagement.searchId(id);
                    if (temp == null) {
                        System.out.println("The product with ID = " + id + " does not exist!");
                        flag = true;
                    } else {
                        System.out.println("Are you sure to remove this user? (Y/N)");
                        String comfirm = scanner.nextLine().toLowerCase();
                        switch (comfirm) {
                            case "Y":
                                userManagement.removeUser(id);
                                break;
                            case "N":
                                break;
                            default:
                                System.out.println("Try again!!");
                                break;
                        }
                    }
                case 0:
                    break;
                default:
                    System.out.println("Try again!");
                    break;
            }
        } while (flag);
    }
}
