package customer;

import product.Product;

public class Customer {
    private long id;
    private String fullName;
    private String email;
    private String address;
    private String phone;

    public Customer() {

    }

    public Customer(long id, String fullName, String email, String address, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phone = phone;
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

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", id, fullName, email, address, phone);
    }
    public static Customer parseCustomer(String raw) {
        String[] fields = raw.split(",");
        Long id = Long.parseLong(fields[0]);
        String fullName = fields[1];
        String email = fields[2];
        String address = fields[3];
        String phone = fields[4];

        Customer customer = new Customer(id, fullName, email, address, phone);

        return customer;
    }
}
