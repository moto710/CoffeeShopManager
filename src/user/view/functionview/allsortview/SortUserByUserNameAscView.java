package user.view.functionview.allsortview;

import user.User;
import user.sort.ById;
import user.sort.ByUserName;
import user.view.UserTemplate;

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
