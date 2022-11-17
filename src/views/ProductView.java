package views;

import views.login.AllAdminManage;
import views.product.functionview.*;
import viewtemplate.ProductTemplate;


public class ProductView extends ProductTemplate {
    public ProductView(){

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        do {
            try {
                menuProductView();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        ShowAllProduct showAllProduct = new ShowAllProduct();
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
                        AllAdminManage allAdminManage = new AllAdminManage();
                        break;
                    default:
                        System.out.println("Wrong input, try again!");
                        flag = true;
                        break;
                }
            } catch (Exception e) {
                System.err.println("Wrong input, try again!!!!!");
                flag = true;
                e.printStackTrace();
            }
        } while (flag);
    }
    public void menuProductView() {
        System.out.println("=========== Choose product's function to show =============");
        System.out.println("=                                                         =");
        System.out.println("=               1. Show all products                      =");
        System.out.println("=               2. Add one product                        =");
        System.out.println("=               3. Edit a product                         =");
        System.out.println("=               4. Remove a product                       =");
        System.out.println("=               5. Search products                        =");
        System.out.println("=               6. Sort products list                     =");
        System.out.println("=               0. Exit                                   =");
        System.out.println("=                                                         =");
        System.out.println("===========================================================");
        System.out.println("Choose function to show!");
        System.out.print("===>");
    }
}
