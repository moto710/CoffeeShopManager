package customer;

import product.Product;
import utils.ReadWriteFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static enums.FilePath.CUSTOMER_LIST_PATH;

public class CustomerManagement {
    private static List<Customer> customerList;

    public CustomerManagement() {
        List<Customer> customerList = new ArrayList<>();
        this.customerList = customerList;
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static void setCustomerList(List<Customer> customerList) {
        CustomerManagement.customerList = customerList;
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
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                break;
            }
        }
        ReadWriteFile.write(CUSTOMER_LIST_PATH.getPath(), list);
    }
    public static Customer searchId(long id) {
        List<Customer> customers = findAll();
        Customer temp = null;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                temp = customers.get(i);
                break;
            }
        }
        return temp;
    }
}