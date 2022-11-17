package views.user.sort;

import models.User;

import java.util.Comparator;

public class ById implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return (int)(o1.getId() - o2.getId());
    }
}
