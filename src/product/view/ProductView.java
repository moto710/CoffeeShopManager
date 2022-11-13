package product.view;


import product.Product;
import product.view.functionview.*;

import java.util.List;

public class ProductView extends ProductTemplate{
    public ProductView(){

    }
    @Override
    protected void showBody() {
        boolean flag = true;
        List<Product> products = productManagement.findAll();

        do {
            try {
                menuProductView();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        showProduct(products);
                        break;
                    case 2:
                        AddProductView addProductView = new AddProductView();
                        break;
                    case 3:
                        EditProductView editProductView = new EditProductView();
                        break;
                    case 4:
                        RemoveProductView removeProductView = new RemoveProductView();
                        break;
                    case 5:
                        SearchProductView searchProductView = new SearchProductView();
                        break;
                    case 6:
                        SortProductView sortProductView = new SortProductView();
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong input, try again!");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Wrong input, try again!!!!!");
                e.printStackTrace();
            }
        } while (flag == true);
    }
    public void menuProductView() {
        System.out.println("Choose product's function to show:\n");
        System.out.println("1. Show all products:");
        System.out.println("2. Add one product:");
        System.out.println("3. Edit a product:");
        System.out.println("4. Remove a product:");
        System.out.println("5. Search products:");
        System.out.println("6. Sort products list:");
        System.out.println("0. Exit!");
    }
}
