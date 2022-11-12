package product.view.functionview;

import product.Product;
import product.view.ProductTemplate;

import java.util.Date;

public class EditProductView extends ProductTemplate {
    public EditProductView(){

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        Product needEdit = new Product();

        do {
            try{
                System.out.println("Enter product ID to edit:");
                int id = Integer.parseInt(scanner.nextLine());

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
                        needEdit.setName(name);
                        needEdit.setDateUpdate(new Date());
                        break;
                    case 2:
                        do {
                            try {
                                System.out.println("Enter new product's inventory:");
                                needEdit.setInventory(Double.parseDouble(scanner.nextLine()));
                                needEdit.setDateUpdate(new Date());
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
                                System.out.println("Enter new product's entry price:");
                                needEdit.setPrice(Integer.parseInt(scanner.nextLine()));
                                needEdit.setDateUpdate(new Date());
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
                        needEdit.setUnit(scanner.nextLine());
                        needEdit.setDateUpdate(new Date());
                        break;
                    case 5:
                        System.out.println("Enter new product's supplier:");
                        needEdit.setSupplier(scanner.nextLine());
                        needEdit.setDateUpdate(new Date());
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
                System.err.println("Wrong input, try again!");
                flag = true;
                scanner.reset();
            }
        } while (flag);

        showProduct(productManagement.getProductList());
    }
    public void menuEdit() {
        System.out.println("What part of product do you want to edit?");
        System.out.println("1. Name:");
        System.out.println("2. Inventory:");
        System.out.println("3. Entry Price:");
        System.out.println("4. Unit");
        System.out.println("5. Supplier:");
    }
}
