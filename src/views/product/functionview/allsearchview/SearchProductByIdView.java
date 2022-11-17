package views.product.functionview.allsearchview;

import viewtemplate.ProductTemplate;

public class SearchProductByIdView extends ProductTemplate {
    public SearchProductByIdView(){

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        int id;

        do {
            try {
                System.out.println("Enter product's ID to search:");
                id = Integer.parseInt(scanner.nextLine());
                if (productManagement.searchId(id) == null) {
                    System.out.printf("Product with ID \"%s\" does not exist!!!\n", id);
                    break;
                }else {
                    showProduct(productManagement.searchId(id));
                }
            } catch (NumberFormatException numberFormatException) {
                System.err.println("Invalid input, re-enter!");
                flag = true;
            }
        } while (flag);
    }
}
