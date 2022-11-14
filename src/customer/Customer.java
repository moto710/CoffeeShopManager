package customer;


import java.util.Date;

import static utils.DateUtils.formatDateToString;

public class Customer {
    private long id;
    private String fullName;
    private String email;
    private String address;
    private String phone;
    private String dateCreate;
    private String dateUpdate;

    public Customer() {

    }

    public Customer(long id, String fullName, String email, String address, String phone, String dateCreate,
                    String dateUpdate) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }
    public Customer(String fullName, String email, String address, String phone) {
        this.id = System.currentTimeMillis()%1000000;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.dateCreate = formatDateToString(new Date());
        this.dateUpdate = formatDateToString(new Date());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s", id, fullName, email, address, phone, dateCreate, dateUpdate);
    }
    public static Customer parseCustomer(String raw) {
        String[] fields = raw.split(",");
        Long id = Long.parseLong(fields[0]);
        String fullName = fields[1];
        String email = fields[2];
        String address = fields[3];
        String phone = fields[4];
        String dateCreate = fields[5];
        String dateUpdate = fields[6];

        Customer customer = new Customer(id, fullName, email, address, phone, dateCreate, dateUpdate);

        return customer;
    }
}
