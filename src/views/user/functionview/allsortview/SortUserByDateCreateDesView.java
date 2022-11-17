package views.user.functionview.allsortview;

import models.User;
import views.user.sort.ByDateCreate;
import viewtemplate.UserTemplate;

import java.util.Collections;
import java.util.List;

import static views.login.view.allloginview.ShowUsersView.showUserList;

public class SortUserByDateCreateDesView extends UserTemplate {
    public SortUserByDateCreateDesView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userService.findAll();
        comparator = new ByDateCreate();
        Collections.sort(users, comparator);
        Collections.reverse(users);
        showUserList(users);
    }
}
