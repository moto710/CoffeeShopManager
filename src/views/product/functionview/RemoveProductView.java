package views.product.functionview;

import models.Product;
import viewtemplate.ProductTemplate;

public class RemoveProductView extends ProductTemplate {
    public RemoveProductView() {

    }

    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            System.out.println("Please enter product's id to remove:");
            Long id = Long.parseLong(scanner.nextLine());
            Product temp = productManagement.searchId(id);

            if (temp == null) {
                System.out.println("The product with id = " + id + " does not exist!");
                flag = true;
            } else {
                System.out.println("Are you sure to remove this product? (Y/N)");
                String comfirm = scanner.nextLine();
                switch (comfirm) {
                    case "Y":
                    case "y":
                        productManagement.removeProduct(id);
                        break;
                    case "N":
                    case "n":
                        break;
                    default:
                        System.out.println("Try again!!");
                        break;
                }
            }
        } while (flag);
    }
}
