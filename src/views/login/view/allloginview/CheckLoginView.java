package views.login.view.allloginview;

import views.login.AdminView;
import views.login.view.LoginTemplate;
import service.UserService;
import models.User;

import java.util.List;

public class CheckLoginView extends LoginTemplate {
    public CheckLoginView() {
//        showPage();
    }

    @Override
    protected void showBody() {
        List<User> userList = UserService.findAll();
        boolean flag = false;
        do {
            System.out.println("Enter your user name:");
            String userName = scanner.nextLine();

            System.out.println("Enter your Password:");
            String password = scanner.nextLine();

            for (User user : userList) {
                String checkUser = user.getUserName();
                String checkPassword = user.getPassword();
                String checkRole = user.getRoleAccount().getValue();

                if (checkUser.equals(userName) && checkPassword.equals(password)) {
                    if (checkRole.equals("ADMIN")) {
                        System.out.println("Welcome back, admin!");
                        System.out.println("Hello " + user.getFullName());
                        AdminView adminView = new AdminView();
                        flag = false;
                        break;
                    }
                    if (checkRole.equals("USER")) {
//                        List<Order> saveUser = new ArrayList<>();
//                        Long id = views.user.getId();
//                        String name = views.user.getFullName();
//                        String phone = views.user.getPhone();
//                        String address = views.user.getAddress();
//                        Instant createAt = Instant.now();
//                        Order newSaveUser = new Order(id, name, phone, address, createAt);
//                        saveUser.add(newSaveUser);
//                        ReadWriteFile.write(SAVE_USER_PATH.getPath(), saveUser);
//                        System.out.println("Welcome back, views.user!");
//                        System.out.println("Hello " + views.user.getFullName());
//                        OptionUser.optionUser();
                        break;
                    }
                }else {
                    System.out.println("Something wrong! Try again");
                    flag = true;
                }
            }
        } while (flag);
    }
}
