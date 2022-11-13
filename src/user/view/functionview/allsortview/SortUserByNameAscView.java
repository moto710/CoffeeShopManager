package user.view.functionview.allsortview;

import user.User;
import user.sort.ByName;
import user.sort.ByUserName;
import user.view.UserTemplate;

import java.util.Collections;
import java.util.List;

public class SortUserByNameAscView extends UserTemplate {
    public SortUserByNameAscView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userManagement.findAll();
        comparator = new ByName();
        Collections.sort(users, comparator);
        showUser(users);
    }
}
