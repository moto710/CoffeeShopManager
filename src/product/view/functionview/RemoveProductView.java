package product.view.functionview;

import product.Product;
import product.view.ProductTemplate;

public class RemoveProductView extends ProductTemplate {
    public RemoveProductView() {

    }

    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            System.out.println("Press 1 key to remove product or 0 to exit!");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Please enter product's id to remove:");
                    Long id = Long.parseLong(scanner.nextLine());

                    Product temp = productManagement.searchId(id);
                    if (temp == null) {
                        System.out.println("The product with id = " + id + " does not exist!");
                        flag = true;
                    } else {
                        System.out.println("Are you sure to remove this product? (Y/N)");
                        String comfirm = scanner.nextLine().toLowerCase();
                        switch (comfirm) {
                            case "Y":
                                productManagement.removeProduct(id);
                                break;
                            case "N":
                                break;
                            default:
                                System.out.println("Try again!!");
                        }
                        break;
                    }
                case 0:
                    break;
                default:
                    System.out.println("Try again!");
                    break;
            }
        } while (flag);
    }
}
