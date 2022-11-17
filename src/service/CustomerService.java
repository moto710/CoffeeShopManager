package service;

import models.Customer;
import utils.ReadWriteFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static enums.FilePath.CUSTOMER_LIST_PATH;
import static utils.DateUtils.formatDateToString;

public class CustomerService {
    private static List<Customer> customerList;

    public CustomerService() {
        List<Customer> customerList = new ArrayList<>();
        this.customerList = customerList;
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static void setCustomerList(List<Customer> customerList) {
        CustomerService.customerList = customerList;
    }
    public static List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        List<String> lines = ReadWriteFile.read(CUSTOMER_LIST_PATH.getPath());
        for (String line : lines) {
            customerList.add(Customer.parseCustomer(line));
        }
        return customerList;
    }
    public static void renderCustomer() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(CUSTOMER_LIST_PATH.getPath()));
            while ((line = br.readLine()) != null) {
                printCustomer(parseCsvLine(line));
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

    public static void printCustomer(List<String> customerList) {
        System.out.printf("%s, %s, %s, %s, %s, %s, %s, %s\n", customerList.get(0), customerList.get(1), customerList.get(2),
                customerList.get(3), customerList.get(4), customerList.get(5), customerList.get(6), customerList.get(7));
    }
    public static void addCustomer(Customer customer) {
        List<Customer> customers = findAll();
        customers.add(customer);
        ReadWriteFile.write(CUSTOMER_LIST_PATH.getPath(), customers);
    }
    public void removeCustomer(long id) {
        List<Customer> list = findAll();
        list.remove(searchId(id));
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId() == id) {
//                list.remove(i);
//                break;
//            }
//        }
        ReadWriteFile.write(CUSTOMER_LIST_PATH.getPath(), list);
    }
    public static Customer searchId(long id) {
        List<Customer> customers = findAll();
        Customer temp = null;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getIdCustomer() == id) {
                temp = customers.get(i);
                break;
            }
        }
        return temp;
    }
    public static void editCustomerName(long id, String name) {
        List<Customer> customers = findAll();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getIdCustomer() == id) {
                customers.get(i).setFullName(name);
                customers.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(CUSTOMER_LIST_PATH.getPath(), customers);
    }
    public static void editCustomerEmail(long id, String email) {
        List<Customer> customers = findAll();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getIdCustomer() == id) {
                customers.get(i).setEmail(email);
                customers.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(CUSTOMER_LIST_PATH.getPath(), customers);
    }
    public static void editCustomerAddress(long id, String address) {
        List<Customer> customers = findAll();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getIdCustomer() == id) {
                customers.get(i).setEmail(address);
                customers.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(CUSTOMER_LIST_PATH.getPath(), customers);
    }
    public static void editCustomerPhone(long id, String phone) {
        List<Customer> customers = findAll();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getIdCustomer() == id) {
                customers.get(i).setPhone(phone);
                customers.get(i).setDateUpdate(formatDateToString(new Date()));
                break;
            }
        }
        ReadWriteFile.write(CUSTOMER_LIST_PATH.getPath(), customers);
    }
    public static List<Customer> searchName(String name) {
        List<Customer> customers = findAll();
        List<Customer> sameName = new ArrayList<>();
        for (Customer item : customers) {
            if (item.getFullName().toUpperCase().contains(name)) {
                sameName.add(item);
            }
        }
        return sameName;
    }
    public static Customer searchEmail(String email) {
        List<Customer> customers = findAll();
        Customer temp = null;
        for (Customer item : customers) {
            if (item.getEmail().equals(email)) {
                temp = item;
                break;
            }
        }
        return temp;
    }
    public static List<Customer> searchAddress(String address) {
        List<Customer> customers = findAll();
        List<Customer> sameAddress = new ArrayList<>();
        for (Customer item : customers) {
            if (item.getAddress().toUpperCase().contains(address)) {
                sameAddress.add(item);
            }
        }
        return sameAddress;
    }
    public static Customer searchPhone(String phone) {
        List<Customer> customers = findAll();
        Customer temp = null;
        for (Customer item : customers) {
            if (item.getPhone().equals(phone)) {
                temp = item;
                break;
            }
        }
        return temp;
    }
}
