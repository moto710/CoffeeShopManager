package views.product.functionview;

import models.Product;
import viewtemplate.ProductTemplate;

public class AddProductView extends ProductTemplate {
    public AddProductView(){

    }
    @Override
    protected void showBody() {
        double inventory = 0;
        int entryPrice = 0;
        boolean flag = false;

        System.out.println("Add new product:");
        System.out.println("----------------");
        System.out.println("Enter new product's name:");
        String name = scanner.nextLine();

        do {
            try {
                System.out.println("Enter new product's inventory:");
                inventory = Double.parseDouble(scanner.nextLine());
                flag = false;
            } catch (Exception e) {
                System.err.println("You must enter a number!");
                flag = true;
                scanner.reset();
            }
        } while (flag);

        System.out.println("Enter new product's unit:");
        String unit = scanner.nextLine();

        do {
            try {
                System.out.println("Enter new product's entry price:");
                entryPrice = Integer.parseInt(scanner.nextLine());
                flag = false;
            } catch (NumberFormatException numberFormatException) {
                System.err.println("Wrong input, re-enter please!");
                scanner.reset();
                flag = true;
            }
        } while (flag);


        System.out.println("Enter new product's supplier:");
        String supplier = scanner.nextLine();

        Product newProduct = new Product(name, inventory, unit, entryPrice, supplier);
        productManagement.addProduct(newProduct);
        showProduct(newProduct);
    }
}
