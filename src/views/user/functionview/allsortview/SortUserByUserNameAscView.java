package views.user.functionview.allsortview;

import models.User;
import views.user.sort.ByUserName;
import viewtemplate.UserTemplate;

import java.util.Collections;
import java.util.List;

import static views.login.view.allloginview.ShowUsersView.showUserList;

public class SortUserByUserNameAscView extends UserTemplate {
    public SortUserByUserNameAscView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userService.findAll();
        comparator = new ByUserName();
        Collections.sort(users, comparator);
        showUserList(users);
    }
}
