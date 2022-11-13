package user.view.functionview.allsortview;

import user.User;
import user.sort.ByDateCreate;
import user.sort.ByName;
import user.view.UserTemplate;

import java.util.Collections;
import java.util.List;

public class SortUserByDateCreateAscView extends UserTemplate {
    public SortUserByDateCreateAscView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userManagement.findAll();
        comparator = new ByDateCreate();
        Collections.sort(users, comparator);
        showUser(users);
    }
}
