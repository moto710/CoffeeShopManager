package views.user.functionview.allsortview;

import models.User;
import views.user.sort.ByName;
import viewtemplate.UserTemplate;

import java.util.Collections;
import java.util.List;

import static views.login.view.allloginview.ShowUsersView.showUserList;

public class SortUserByNameAscView extends UserTemplate {
    public SortUserByNameAscView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userService.findAll();
        comparator = new ByName();
        Collections.sort(users, comparator);
        showUserList(users);
    }
}
