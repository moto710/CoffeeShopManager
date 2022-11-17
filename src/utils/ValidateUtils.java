package utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String NAME_PATTERN = "^([A-ZÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬĐÈẺẼÉẸÊỀỂỄẾỆÌỈĨÍỊÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢÙỦŨÚỤƯỪỬỮỨỰỲỶỸÝỴ][a-zàảãáạăằẳẵắặâầẩẫấậđèẻẽéẹêềểễếệiìỉĩíịòỏõóọôồổỗốộơờởỡớợùủũúụỤưừửữứựỳỷỹýỵ]{0,6} ?)*$";;
    public static final String PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$";
    public static final String USERNAME_PATTERN = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String PHONE_PATTERN = "^0[1-9][0-9]{8}$";
    public static final String CHOICE_PATTERN = "^[1-3]$";
    public static final String LOGIN_CHOICE_PATTERN = "^[1-2]$";
    public static final String QUANTITY_PATTERN = "^[1-100000]$";

    public static boolean isPasswordValid(String password) {
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }

    public static boolean isNameValid(String name) {
        return Pattern.compile(NAME_PATTERN).matcher(name).matches();
    }

    public static boolean isUserNameValid(String userName) {
        return Pattern.compile(USERNAME_PATTERN).matcher(userName).matches();
    }

    public static boolean isPhoneValid(String phone) {
        return Pattern.compile(PHONE_PATTERN).matcher(phone).matches();
    }

    public static boolean isEmailValid(String email) {
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }

    public static boolean isRoleValid(String role) {
        return Pattern.compile(CHOICE_PATTERN).matcher(role).matches();
    }
    public static boolean isLoginValid(String login){
        return Pattern.compile(LOGIN_CHOICE_PATTERN).matcher(login).matches();
    }
    public static boolean isQuantityValid(String role) {
        return Pattern.compile(QUANTITY_PATTERN).matcher(role).matches();
    }
}
