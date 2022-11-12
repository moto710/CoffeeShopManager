package utils;

import user.UserManagement;

import java.util.Scanner;

public class UserValidateUltils {
    static Scanner input = new Scanner(System.in);

    public static String inputUserName() {
        String userName = "";
        do {
            System.out.println("Nhập username muốn tạo hoặc sửa (bao gồm 6 ký tự): ");
            userName = input.nextLine();
            if (!ValidateUltils.isUsernameValid(userName)) {
                System.out.println("Tên không đúng quy định vui lòng nhập lại !!");
            }
            if (UserManagement.isUserNameInList(userName)) {
                System.out.println("Username đã có, vui lòng nhập lại !!");
                UserManagement.addUser();
                break;
            }
        }
        while (!ValidateUltils.isUsernameValid(userName));
        return userName;
    }

    public static String inputPassWord() {
        String passWord = "";
        do {
            System.out.println("Nhập Password (Mật khẩu có ít nhất 1 ký tự hoa , 1 số, 1 ký tự thường, 1 ký tự đặc biệt và trên 6 chữ số): ");
            passWord = input.nextLine();
            if (!ValidateUltils.isPassswordValid(passWord)) {
                System.out.println("Mật khẩu yếu");
            }
        }
        while (!ValidateUltils.isPassswordValid(passWord));
        return passWord;
    }

    public static String inputFullName() {
        String fullName = "";
        do {
            System.out.println("Nhập tên người dùng: (Ví dụ : Nguyễn Văn Hà) ");
            fullName = input.nextLine();
            if (!ValidateUltils.isNameValid(fullName)) {
                System.out.println("Tên không đúng định dạng vui lòng nhập lại!");
            }

        } while (!ValidateUltils.isNameValid(fullName));
        return fullName;
    }

    public static String inputPhone() {
        String phone = "";
        do {
            System.out.println("Nhập số điện thoại người dùng (Bắt đầu bằng số 0 , yêu cầu đủ 10 số): ");
            phone = input.nextLine();
            if (!ValidateUltils.isPhoneValid(phone)) {
                System.out.println("Không đúng định dạng vui lòng nhập lại:");
            }
        } while (!ValidateUltils.isPhoneValid(phone));
        return phone;
    }

    public static String inputEmail() {
        String email = "";
        do {
            System.out.println("Nhập email người dùng : (Ví dụ : nguyenvanha2410@gmail.com)");
            email = input.nextLine();
            if (!ValidateUltils.isEmailValid(email))
                System.out.println("Không đúng định dạng vui lòng nhập lại!!");
        } while (!ValidateUltils.isEmailValid(email));
        return email;
    }

    public static String inputRole() {
        String inputRole = "";
        String choice = "";
        do {
            System.out.println("㊋㊋㊋㊋㊋㊋ROLE㊋㊋㊋㊋㊋㊋㊋");
            System.out.println("        " + "1.SADMIN" + "       ㊋");
            System.out.println("        " + "2.ADMIN" + "        ㊋");
            System.out.println("        " + "3.USER" + "         ㊋ ");
            System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
            System.out.println("Chọn role bạn muốn thêm : ");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    inputRole = "SADMIN";
                    break;
                case "2":
                    inputRole = "ADMIN";
                    break;
                case "3":
                    inputRole = "USER";
                    break;
            }
            if (!ValidateUltils.isRoleValid(choice)) {
                System.out.println("Không đúng định dạng vui lòng nhập lại!!!");
            }
        } while (!ValidateUltils.isRoleValid(choice));
        return inputRole;
    }

}
