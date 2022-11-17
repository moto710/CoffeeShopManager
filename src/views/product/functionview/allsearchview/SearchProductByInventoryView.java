package views.product.functionview.allsearchview;

import viewtemplate.ProductTemplate;

public class SearchProductByInventoryView extends ProductTemplate {
    public SearchProductByInventoryView(){

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        int inventory;
        do {
            try {
                System.out.println("Enter views.product's inventory to search:");
                inventory = Integer.parseInt(scanner.nextLine());

                if (productManagement.searchInventory(inventory) == null) {
                    System.out.printf("There is no views.product with inventory = %s \n", inventory);
                }else {
                    showProduct(productManagement.searchInventory(inventory));
                }
            }catch(NumberFormatException numberFormatException){
                System.err.println("Invalid input, re-enter please!!!");
                flag = true;
            }
        }while(flag);
    }
}
