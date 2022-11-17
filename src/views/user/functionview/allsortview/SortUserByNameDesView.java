package views.user.functionview.allsortview;

import models.User;
import views.user.sort.ByName;
import viewtemplate.UserTemplate;

import java.util.Collections;
import java.util.List;

public class SortUserByNameDesView extends UserTemplate {
    public SortUserByNameDesView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userManagement.findAll();
        comparator = new ByName();
        Collections.sort(users, comparator);
        Collections.reverse(users);
        showUser(users);
    }
}
