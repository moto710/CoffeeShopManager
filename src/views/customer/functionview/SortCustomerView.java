package views.customer.functionview;

import views.customer.functionview.allsortview.*;
import viewtemplate.CustomerTemplate;

public class SortCustomerView extends CustomerTemplate {
    public SortCustomerView() {

    }
    @Override
    protected void showBody() {
        boolean flag = true;
        do {
            menuSort();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    SortCustomerByIdAscView sortCustomerByIdAscView = new SortCustomerByIdAscView();
                    break;
                case 2:
                    SortCustomerByIdDesView sortCustomerByIdDesView = new SortCustomerByIdDesView();
                    break;
                case 3:
                    SortCustomerByNameAscView sortCustomerByNameAscView = new SortCustomerByNameAscView();
                    break;
                case 4:
                    SortCustomerByNameDesView sortCustomerByNameDesView = new SortCustomerByNameDesView();
                    break;
                case 5:
                    SortCustomerByEmailAscView sortCustomerByNameAscView1 = new SortCustomerByEmailAscView();
                    break;
                case 6:
                    SortCustomerByEmailDesView sortCustomerByNameDesView1 = new SortCustomerByEmailDesView();
                    break;
                case 7:
                    SortCustomerByDateCreateAscView sortCustomerByDateCreateAscView = new SortCustomerByDateCreateAscView();
                    break;
                case 8:
                    SortCustomerByDateCreateDesView sortCustomerByDateCreateDesView = new SortCustomerByDateCreateDesView();
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
        System.out.println("============ What style of sort do you want? ==============");
        System.out.println("=                                                         =");
        System.out.println("=            1. Sort by ID with ascending                 =");
        System.out.println("=            2. Sort by ID with descending                =");
        System.out.println("=            3. Sort by name with ascending               =");
        System.out.println("=            4. Sort by name with descending              =");
        System.out.println("=            5. Sort by email with ascending              =");
        System.out.println("=            6. Sort by email with descending             =");
        System.out.println("=            7. Sort by date create with ascending        =");
        System.out.println("=            8. Sort by date create with descending       =");
        System.out.println("=            0. Exit!                                     =");
        System.out.println("=                                                         =");
        System.out.println("===========================================================");
        System.out.println("Choose function to show!");
        System.out.print("===>");
    }
}
