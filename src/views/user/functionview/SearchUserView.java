package views.user.functionview;

import views.user.functionview.allsearchview.*;
import viewtemplate.UserTemplate;

public class SearchUserView extends UserTemplate {
    public SearchUserView(){

    }
    @Override
    protected void showBody() {
        boolean flag = true;
        do {
            menuUserView();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    SearchUserByIdView searchUserByIdView = new SearchUserByIdView();
                    break;
                case 2:
                    SearchUserByUserNameView searchUserByUserNameView = new SearchUserByUserNameView();
                    break;
                case 3:
                    SearchUserByPasswordView searchUserByPasswordView = new SearchUserByPasswordView();
                    break;
                case 4:
                    SearchUserByNameView searchUserByNameView = new SearchUserByNameView();
                    break;
                case 5:
                    SearchUserByPhoneView searchUserByPhoneView = new SearchUserByPhoneView();
                    break;
                case 6:
                    SearchUserByEmailView searchUserByEmailView = new SearchUserByEmailView();
                    break;
                case 7:
                    SearchUserByAddressView searchUserByAddressView = new SearchUserByAddressView();
                    break;
                case 8:
                    SearchUserByRoleView searchProductBySupplierView = new SearchUserByRoleView();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong input, enter again!");
                    break;
            }
        } while (flag);
    }
    protected void menuUserView() {
        System.out.println("============ Search user by ==============");
        System.out.println("=                                        =");
        System.out.println("=              1. ID                     =");
        System.out.println("=              2. User Name              =");
        System.out.println("=              3. Password               =");
        System.out.println("=              4. Full name              =");
        System.out.println("=              5. Phone number           =");
        System.out.println("=              6. Email                  =");
        System.out.println("=              7. Address                =");
        System.out.println("=              8. Role                   =");
        System.out.println("=              0. Exit                   =");
        System.out.println("=                                        =");
        System.out.println("===========================================");
        System.out.println("Enter your choice!");
        System.out.print("==> ");
    }
}
