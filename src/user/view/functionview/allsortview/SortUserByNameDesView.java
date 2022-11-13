package user.view.functionview.allsortview;

import user.User;
import user.sort.ByName;
import user.view.UserTemplate;

import java.util.Collections;
import java.util.List;

public class SortUserByNameDesView extends UserTemplate {
    public SortUserByNameDesView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userManagement.findAll();
        comparator = new ByName();
        Collections.sort(users, comparator);
        Collections.reverse(users);
        showUser(users);
    }
}
