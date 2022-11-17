package views.product.functionview;

import views.product.functionview.allsortview.*;
import viewtemplate.ProductTemplate;

public class SortProductView extends ProductTemplate {
    public SortProductView(){

    }
    @Override
    protected void showBody() {
        boolean flag = true;
        do {
            menuSort();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    SortProductByIdAscView sortProductByIdView = new SortProductByIdAscView();
                    break;
                case 2:
                    SortProductByIdDesView sortProductByIdDesView = new SortProductByIdDesView();
                    break;
                case 3:
                    SortProductByNameAscView sortProductByNameAscView = new SortProductByNameAscView();
                    break;
                case 4:
                    SortProductByNameDesView sortProductByNameDesView = new SortProductByNameDesView();
                    break;
                case 5:
                    SortByDateCreateAscView sortByDateCreateAscView = new SortByDateCreateAscView();
                    break;
                case 6:
                    SortByDateCreateDesView sortByDateCreateDesView = new SortByDateCreateDesView();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong input, choose again!");
                    break;
            }

        } while (flag);
    }
    public void menuSort(){
        System.out.println("================= What style of sort do you want? ===================");
        System.out.println("=                                                                   =");
        System.out.println("=                1. Sort by ID with ascending                       =");
        System.out.println("=                2. Sort by ID with descending                      =");
        System.out.println("=                3. Sort by name with ascending                     =");
        System.out.println("=                4. Sort by name with descending                    =");
        System.out.println("=                5. Sort by date create with ascending              =");
        System.out.println("=                6. Sort by date create with descending             =");
        System.out.println("=                0. Exit!                                           =");
        System.out.println("=                                                                   =");
        System.out.println("=====================================================================");
        System.out.println("Choose function to show!");
        System.out.print("===>");
    }
}
