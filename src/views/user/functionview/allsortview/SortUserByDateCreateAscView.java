package views.user.functionview.allsortview;

import models.User;
import views.user.sort.ByDateCreate;
import viewtemplate.UserTemplate;

import java.util.Collections;
import java.util.List;

public class SortUserByDateCreateAscView extends UserTemplate {
    public SortUserByDateCreateAscView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userManagement.findAll();
        comparator = new ByDateCreate();
        Collections.sort(users, comparator);
        showUser(users);
    }
}
