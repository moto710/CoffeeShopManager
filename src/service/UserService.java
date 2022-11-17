package service;

import enums.RoleAccount;
import models.User;
import utils.*;

import java.io.*;
import java.util.*;

import static enums.FilePath.USER_LIST_PATH;
import static utils.DateUtils.formatDateToString;

public class UserService {
    public static List<User> findAll() {
        List<User> users = new ArrayList<>();
        List<String> lines = ReadWriteFile.read(USER_LIST_PATH.getPath());
        for (String line : lines) {
            users.add(User.parseUser(line));
        }
        return users;
    }

    public static void renderUser() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(USER_LIST_PATH.getPath()));
            while ((line = br.readLine()) != null) {
                printUser(parseCsvLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static void printUser(List<String> userList) {
        System.out.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", userList.get(0), userList.get(1), userList.get(2),
                userList.get(3), userList.get(4), userList.get(5), userList.get(6), userList.get(7), userList.get(8),
                userList.get(9));
    }
    public static void addUser(User user) {
        List<User> users = findAll();
        users.add(user);
        ReadWriteFile.write(USER_LIST_PATH.getPath(), users);
    }
    public void editUserUserName(long id, String userName) {
        List<User> users = findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.get(i).setUserName(userName);
                users.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(USER_LIST_PATH.getPath(), users);
    }
    public void editUserPassword(long id, String password) {
        List<User> users = findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.get(i).setPassword(password);
                users.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(USER_LIST_PATH.getPath(), users);
    }
    public void editUserFullName(long id, String fullName) {
        List<User> users = findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.get(i).setFullName(fullName);
                users.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(USER_LIST_PATH.getPath(), users);
    }
    public void editUserPhone(long id, String phone) {
        List<User> users = findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.get(i).setPhone(phone);
                users.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(USER_LIST_PATH.getPath(), users);
    }
    public void editUserEmail(long id, String email) {
        List<User> users = findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.get(i).setEmail(email);
                users.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(USER_LIST_PATH.getPath(), users);
    }
    public void editUserAddress(long id, String address) {
        List<User> users = findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.get(i).setAddress(address);
                users.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(USER_LIST_PATH.getPath(), users);
    }
    public void editUserRole(long id, RoleAccount role) {
        List<User> users = findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.get(i).setRoleAccount(role);
                users.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(USER_LIST_PATH.getPath(), users);
    }

    public void removeUser(long id) {
        List<User> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                break;
            }
        }
        ReadWriteFile.write(USER_LIST_PATH.getPath(), list);
    }
    public static User searchId(long id) {
        List<User> users = findAll();
        User temp = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                temp = users.get(i);
                break;
            }
        }
        return temp;
    }
    public static User searchUserName(String userName) {
        List<User> users = findAll();
        User temp = null;
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                temp = user;
                break;
            }
        }
        return temp;
    }

    public static List<User> searchPassword(String password) {
        List<User> users = findAll();
        List<User> samePassword = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPassword() == password) {
                samePassword.add(users.get(i));
                count++;
            } else if (count == 0 && i == users.size() - 1) {
                samePassword = null;
            }
        }
        return samePassword;
    }


    public static List<User> searchName(String name) {
        List<User> users = findAll();
        List<User> sameName = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getFullName().equalsIgnoreCase(name)) {
                sameName.add(users.get(i));
                count++;
            } else if (count == 0 && i == users.size() - 1) {
                sameName = null;
            }
        }
        return sameName;
    }
    public static User searchPhone(String phone) {
        List<User> users = findAll();
        User temp = null;
        for (User user : users) {
            if (user.getPhone().equals(phone)) {
                temp = user;
                break;
            }
        }
        return temp;
    }
    public static User searchEmail(String email) {
        List<User> users = findAll();
        User temp = null;
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                temp = user;
                break;
            }
        }
        return temp;
    }


    public static List<User> searchAddress(String address) {
        List<User> users = findAll();
        List<User> sameAddress = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getAddress().toUpperCase().contains(address.toUpperCase())) {
                sameAddress.add(users.get(i));
                count++;
            } else if (count == 0 && i == users.size() - 1) {
                sameAddress = null;
            }
        }
        return sameAddress;
    }
    public static List<User> searchRole(String role) {
        List<User> users = findAll();
        List<User> sameRole = new ArrayList<>();
        for (User user : users) {
            if (user.getRoleAccount().getValue().equalsIgnoreCase(role)) {
                sameRole.add(user);
            }
        }
        return sameRole;
    }
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        List<String> records = ReadWriteFile.read(USER_LIST_PATH.getPath());
        for (String record : records) {
            users.add(User.parseUser(record));
        }
        return users;
    }

}
