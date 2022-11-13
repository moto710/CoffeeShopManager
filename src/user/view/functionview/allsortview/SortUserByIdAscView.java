package user.view.functionview.allsortview;

import user.User;
import user.sort.ById;
import user.view.UserTemplate;

import java.util.Collections;
import java.util.List;

public class SortUserByIdAscView extends UserTemplate {
    public SortUserByIdAscView(){

    }
    @Override
    protected void showBody() {
        List<User> users = userManagement.findAll();
        comparator = new ById();
        Collections.sort(users, comparator);
        showUser(users);
    }
}
