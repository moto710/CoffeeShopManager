package models;

import enums.RoleAccount;

import java.util.Date;

import static enums.RoleAccount.USER;
import static enums.RoleAccount.parseRole;
import static utils.DateUtils.formatDateToString;

public class User {
    private long id;
    private String userName;
    private String password;
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private RoleAccount role;
    private String dateCreate;
    private String dateUpdate;

    public User() {
    }

    public User(String userName, String password, String fullName, String phone, String email, String address,
                RoleAccount role) {
        this.id = System.currentTimeMillis() % 1000000;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = role;
        this.dateCreate = formatDateToString(new Date());
        this.dateUpdate = formatDateToString(new Date());
    }
    public User(String userName, String password, String fullName, String phone, String email, String address) {
        this.id = System.currentTimeMillis() % 1000000;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateCreate = formatDateToString(new Date());
        this.dateUpdate = formatDateToString(new Date());
        this.role = USER;
    }
    public static User parseUser(String raw) {
        User user = new User();
        String[] fields = raw.split(",");
        user.id = Long.parseLong(fields[0]);
        user.userName = fields[1];
        user.password = fields[2];
        user.fullName = fields[3];
        user.phone = fields[4];
        user.email = fields[5];
        user.address = fields[6];
        user.role = parseRole(fields[7]);
        user.dateCreate = (fields[8]);
        user.dateUpdate = (fields[9]);
        return user;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RoleAccount getRoleAccount() {
        return role;
    }

    public void setRoleAccount(RoleAccount role) {
        this.role = role;
    }
    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getDateCreate() {
        return dateCreate;
    }


    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s,%s", id, userName, password, fullName, phone, email, address,
                role, dateCreate, dateUpdate);
    }
}
