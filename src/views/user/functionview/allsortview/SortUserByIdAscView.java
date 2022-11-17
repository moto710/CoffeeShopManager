package views.user.functionview.allsortview;

import models.User;
import views.user.sort.ById;
import viewtemplate.UserTemplate;

import java.util.Collections;
import java.util.List;

import static views.login.view.allloginview.ShowUsersView.showUserList;

public class SortUserByIdAscView extends UserTemplate {
    public SortUserByIdAscView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userService.findAll();
        comparator = new ById();
        Collections.sort(users, comparator);
        showUserList(users);
    }
}
