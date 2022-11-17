package views.product.functionview;

import models.Product;
import viewtemplate.ProductTemplate;


public class EditProductView extends ProductTemplate {
    public EditProductView(){

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        Product needEdit;
        int id = 0;

        do {
            try{
                System.out.println("Enter product's ID to edit:");
                id = Integer.parseInt(scanner.nextLine());

                needEdit = productManagement.searchId(id);
                if (needEdit == null) {
                    System.out.println("Don't find product with ID = " + id);
                    flag = true;
                } else {
                    System.out.println(needEdit);
                    flag = false;
                }
            }catch(NumberFormatException n){
                System.err.println("Wrong ID, try again!");
                flag = true;
                scanner.reset();
            }
        } while(flag);


        do {
            try {
                menuEdit();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter new product's name");
                        String name = scanner.nextLine();
                        productManagement.editProductName(id, name);
                        break;
                    case 2:
                        do {
                            try {
                                System.out.println("Enter new product's inventory:");
                                productManagement.editProductInventory(id, Double.parseDouble(scanner.nextLine()));
                                flag = false;
                            } catch (Exception e) {
                                System.err.println("You must enter a number!");
                                flag = true;
                                scanner.reset();
                            }
                        } while (flag);
                        break;
                    case 3:
                        do {
                            try {
                                System.out.println("Enter new product's price:");
                                productManagement.editProductPrice(id,Integer.parseInt(scanner.nextLine()));
                                flag = false;
                                break;
                            } catch (NumberFormatException numberFormatException) {
                                System.err.println("Wrong input, re-enter please!");
                                scanner.reset();
                                flag = true;
                            }
                        } while (flag);
                        break;
                    case 4:
                        System.out.println("Enter new product's unit:");
                        productManagement.editProductUnit(id, scanner.nextLine());
                        break;
                    case 5:
                        System.out.println("Enter new product's supplier:");
                        productManagement.editProductSupplier(id, scanner.nextLine());
                        break;
                    case 0:
                        System.out.println("Exit!");
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong input, enter again!");
                        flag = true;
                        break;
                }
            } catch (Exception e) {
                System.err.println("Wrong input, try again, bae!");
                flag = true;
                scanner.reset();
            }
        } while (flag);
    }
    public void menuEdit() {
        System.out.println("=========== What part of product do you want to edit? =============");
        System.out.println("=                                                                 =");
        System.out.println("=                         1. Name                                 =");
        System.out.println("=                         2. Inventory                            =");
        System.out.println("=                         3. Price                                =");
        System.out.println("=                         4. Unit                                 =");
        System.out.println("=                         5. Supplier                             =");
        System.out.println("=                         0. Exit!                                =");
        System.out.println("=                                                                 =");
        System.out.println("===================================================================");
        System.out.println("Choose function to show!");
        System.out.print("===>");
    }
}
