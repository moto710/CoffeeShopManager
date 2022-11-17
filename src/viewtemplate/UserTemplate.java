package viewtemplate;

import models.User;
import service.UserService;
import viewtemplate.ViewTemplate;

import java.util.Comparator;
import java.util.List;

public abstract class UserTemplate extends ViewTemplate {
    protected static UserService userManagement;

    protected Comparator<User> comparator;
    protected UserTemplate(){
        userManagement = new UserService();
    }
    public static void showUser(List<User> users){
        for (User user : users) {
            System.out.println(user);
        }
    }
}
