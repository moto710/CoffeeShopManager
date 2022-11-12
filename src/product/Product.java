package product;

import java.util.Date;

import static utils.DateUtils.parseStringToDate;

public class Product {
    private Long id;
    private String name;
    private double inventory;
    private String unit;
    private double price;
    private String supplier;
    private Date dateCreate;
    private Date dateUpdate;


    public Product() {

    }

    public Product(String name, double inventory, String unit, double price, String supplier) {
        this.id = System.currentTimeMillis() % 1000000;
        this.name = name;
        this.inventory = inventory;
        this.unit = unit;
        this.price = price;
        this.supplier = supplier;
        this.dateCreate = new Date();
        this.dateUpdate = new Date();
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

    public Date getDateCreate() {
        return dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Long getId() {
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
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inventory=" + inventory +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", supplier='" + supplier + '\'' +
                ", dateCreate=" + dateCreate +
                ", dateUpdate=" + dateUpdate +
                '}';
    }

    public static Product parseProduct(String raw) {
        Product product = new Product();
        String[] fields = raw.split(",");
        product.id = Long.parseLong(fields[0]);
        product.name = fields[1];
        product.inventory = Double.parseDouble(fields[2]);
        product.unit = fields[3];
        product.price = Double.parseDouble(fields[4]);
        product.supplier = fields[5];
        product.dateCreate = parseStringToDate(fields[6]);
        product.dateUpdate = parseStringToDate(fields[7]);

        return product;
    }
}
