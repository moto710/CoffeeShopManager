package views.user.functionview.allsortview;

import models.User;
import views.user.sort.ByUserName;
import viewtemplate.UserTemplate;

import java.util.Collections;
import java.util.List;

public class SortUserByUserNameAscView extends UserTemplate {
    public SortUserByUserNameAscView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userManagement.findAll();
        comparator = new ByUserName();
        Collections.sort(users, comparator);
        showUser(users);
    }
}
