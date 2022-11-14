package login.view.allloginview;

import login.view.LoginTemplate;
import surface.OptionAdmin;
import surface.OptionUser;
import utils.ReadWriteFile;
import user.UserManagement;
import order.order.Order;
import user.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static enums.FilePath.SAVE_USER_PATH;

public class CheckLoginView extends LoginTemplate {
    public CheckLoginView() {
        showPage();
    }

    @Override
    protected void showBody() {
        List<User> userList = UserManagement.findAll();
        int count = 0;
        do {
            System.out.println("Enter your user name:");
            String userName = scanner.nextLine();

            System.out.println("Enter your Password:");
            String passWord = scanner.nextLine();

            for (User user : userList) {
                String checkUser = user.getUserName();
                String checkPassWord = user.getPassword();
                String checkRole = user.getRoleAccount().getValue();

                if (checkUser.equals(userName) && checkPassWord.equals(passWord)) {
                    if (checkRole.equals("ADMIN")) {
                        System.out.println("Welcome back, admin!");
                        System.out.println("Hello " + user.getFullName());
                        OptionAdmin optionAdmin = new OptionAdmin();
                        break;
                    }
                    if (checkRole.equals("USER")) {
                        List<Order> saveUser = new ArrayList<>();
                        Long id = user.getId();
                        String name = user.getFullName();
                        String phone = user.getPhone();
                        String address = user.getAddress();
                        Instant createAt = Instant.now();
                        Order newSaveUser = new Order(id, name, phone, address, createAt);
                        saveUser.add(newSaveUser);
                        ReadWriteFile.write(SAVE_USER_PATH.getPath(), saveUser);
                        System.out.println("Welcome back, user!");
                        System.out.println("Hello " + user.getFullName());
//                        OptionUser.optionUser();
                        break;
                    }
                }else {
                    System.out.println("Something wrong! Try again");
                }
            }
        } while (count == 0);
    }
}
