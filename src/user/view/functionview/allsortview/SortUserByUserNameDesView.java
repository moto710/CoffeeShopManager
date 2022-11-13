package user.view.functionview.allsortview;

import user.User;
import user.sort.ByUserName;
import user.view.UserTemplate;
import user.view.UserView;

import java.util.Collections;
import java.util.List;

public class SortUserByUserNameDesView extends UserTemplate {
    public SortUserByUserNameDesView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userManagement.findAll();
        comparator = new ByUserName();
        Collections.sort(users, comparator);
        Collections.reverse(users);
        showUser(users);
    }
}
