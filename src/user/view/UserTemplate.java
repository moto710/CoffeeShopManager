package user.view;

import product.Product;
import product.ProductManagement;
import user.User;
import user.UserManagement;
import viewtemplate.ViewTemplate;

import java.util.Comparator;
import java.util.List;

public abstract class UserTemplate extends ViewTemplate {
    protected static UserManagement userManagement;

    protected Comparator<Product> comparator;
    protected UserTemplate(){
        userManagement = new UserManagement();
    }
    public static void showProduct(List<User> users){
        for (User user : users) {
            System.out.println(user);
        }
    }
}
