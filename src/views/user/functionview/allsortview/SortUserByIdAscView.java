package views.user.functionview.allsortview;

import models.User;
import views.user.sort.ById;
import viewtemplate.UserTemplate;

import java.util.Collections;
import java.util.List;

public class SortUserByIdAscView extends UserTemplate {
    public SortUserByIdAscView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userManagement.findAll();
        comparator = new ById();
        Collections.sort(users, comparator);
        showUser(users);
    }
}
