package views.user.sort;

import models.User;

import java.util.Comparator;

public class ByDateCreate implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getDateCreate().compareTo(o2.getDateCreate());
    }
}
