package views.user.functionview.allsortview;

import models.User;
import views.user.sort.ByDateCreate;
import viewtemplate.UserTemplate;

import java.util.Collections;
import java.util.List;

public class SortUserByDateCreateDesView extends UserTemplate {
    public SortUserByDateCreateDesView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userManagement.findAll();
        comparator = new ByDateCreate();
        Collections.sort(users, comparator);
        Collections.reverse(users);
        showUser(users);
    }
}
