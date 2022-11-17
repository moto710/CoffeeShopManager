package views.login.view.allloginview;

import models.User;
import service.UserService;
import viewtemplate.UserTemplate;

import java.util.List;

public class ShowUsersView extends UserTemplate {
    @Override
    protected void showBody() {
        List<User> users = UserService.getUsers();
        showUserList(users);
    }

    public static void showUserList(List<User> list) {
        System.out.println("========================================================================= USER LIST ====================================================================================\n");
        System.out.printf("|%-12s| |%-12s| | %-18s |  | %-16s | %-20s | %-15s |  | %-10s |  | %-20s |  | %-20s |\n", "ID", "User name", "Name", "Phone number", "Email", "Address", "Role", "Date Create", "Date Update");
        System.out.println("");
        for (User user : list) {
            System.out.printf("|%-12s| |%-12s| | %-18s |  | %-16s | %-20s | %-15s |  | %-10s |  | %-20s |  | %-20s |\n", user.getId(), user.getUserName(), user.getFullName(), user.getPhone(), user.getEmail(), user.getAddress(), user.getRoleAccount(), user.getDateCreate(), user.getDateUpdate());
        }
        System.out.println("=========================================================================================================================================================================");

    }

    public static void printUser(User user) {
        System.out.println("========================================================================= USER ====================================================================================\n");
        System.out.printf("|%-12s| |%-12s| | %-18s |  | %-16s | %-20s | %-15s |  | %-10s |  | %-20s |  | %-20s |\n", "ID", "User name", "Name", "Phone number", "Email", "Address", "Role", "Date Create", "Date Update");
        System.out.println("");
        System.out.printf("|%-12s| |%-12s| | %-18s |  | %-16s | %-20s | %-15s |  | %-10s |  | %-20s |  | %-20s |\n", user.getId(), user.getUserName(), user.getFullName(), user.getPhone(), user.getEmail(), user.getAddress(), user.getRoleAccount(), user.getDateCreate(), user.getDateUpdate());
        System.out.println("====================================================================================================================================================================");

    }
}
