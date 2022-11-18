package models;

import java.util.Date;

import static utils.DateUtils.formatDateToString;

public class Product {
    private long id;
    private String name;
    private double inventory;
    private String unit;
    private double price;
    private String supplier;
    private String dateCreate;
    private String dateUpdate;


    public Product() {

    }

    public Product(String name, double inventory, String unit, double price, String supplier) {
        this.id = System.currentTimeMillis() % 1000000;
        this.name = name;
        this.inventory = inventory;
        this.unit = unit;
        this.price = price;
        this.supplier = supplier;
        this.dateCreate = formatDateToString(new Date());
        this.dateUpdate = formatDateToString(new Date());
    }
    public Product(long id, String name, double inventory, String unit, double price, String supplier, String dateCreate,
                   String dateUpdate) {
        this.id = id;
        this.name = name;
        this.inventory = inventory;
        this.unit = unit;
        this.price = price;
        this.supplier = supplier;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getInventory() {
        return inventory;
    }

    public void setInventory(double inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", id, name, inventory, unit, price, supplier, dateCreate, dateUpdate);
    }

    public static Product parseProduct(String raw) {
        String[] fields = raw.split(",");
        long id = Long.parseLong(fields[0]);
        String name = fields[1];
        double inventory = Double.parseDouble(fields[2]);
        String unit = fields[3];
        double price = Double.parseDouble(fields[4]);
        String supplier = fields[5];
        String dateCreate = fields[6];
        String dateUpdate = fields[7];

        return new Product(id, name, inventory, unit, price, supplier, dateCreate, dateUpdate);
    }
}
