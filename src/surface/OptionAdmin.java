package surface;

import login.view.LoginTemplate;
import product.view.ProductView;
import user.view.UserView;

public class OptionAdmin extends LoginTemplate {

    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            menuAdmin();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    UserView userView = new UserView();
                    break;
                case 2:
                    ProductView productView = new ProductView();
                    break;
                case 3: //manage cart
                    break;
                case 0: //exit
                    break;
                default:
                    break;
            }

        }while (flag);
    }
    public static void menuAdmin() {
        System.out.println("-------------------------------------------------------");
        System.out.println("");
        System.out.println("\t1. Manage User");
        System.out.println("\t2. Manage Product");
        System.out.println("\t2. Manage Cart");
        System.out.println("\t0. Exit!");
        System.out.println("");
        System.out.println("-------------------------------------------------------");
        System.out.println("Enter your choice:");
        System.out.print("===>");
    }
}

