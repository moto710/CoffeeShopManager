package views.user.functionview;

import views.user.functionview.allsortview.*;
import viewtemplate.UserTemplate;

public class SortUserView extends UserTemplate {
    public SortUserView(){

    }
    @Override
    protected void showBody() {
        boolean flag = true;
        do {
            menuSort();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    SortUserByIdAscView sortUserByIdAscView = new SortUserByIdAscView();
                    break;
                case 2:
                    SortUserByIdDesView sortUserByIdDesView = new SortUserByIdDesView();
                    break;
                case 3:
                    SortUserByUserNameAscView sortUserByUserNameAscView = new SortUserByUserNameAscView();
                    break;
                case 4:
                    SortUserByUserNameDesView sortUserByUserNameDesView = new SortUserByUserNameDesView();
                    break;
                case 5:
                    SortUserByNameAscView sortUserByNameAscView = new SortUserByNameAscView();
                    break;
                case 6:
                    SortUserByNameDesView sortUserByNameDesView = new SortUserByNameDesView();
                    break;
                case 7:
                    SortUserByDateCreateAscView sortUserByDateCreateAscView = new SortUserByDateCreateAscView();
                    break;
                case 8:
                    SortUserByDateCreateDesView sortByDateCreateDesView = new SortUserByDateCreateDesView();
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
        System.out.println("=            1. Sort by ID with ascending                           =");
        System.out.println("=            2. Sort by ID with descending                          =");
        System.out.println("=            3. Sort by user name with ascending                    =");
        System.out.println("=            4. Sort by user name with descending                   =");
        System.out.println("=            5. Sort by name with ascending                         =");
        System.out.println("=            6. Sort by name with descending                        =");
        System.out.println("=            7. Sort by date create with ascending                  =");
        System.out.println("=            8. Sort by date create with descending                 =");
        System.out.println("=            0. Exit!                                               =");
        System.out.println("=                                                                   =");
        System.out.println("=====================================================================");
        System.out.println("Choose function to show!");
        System.out.print("===>");
    }
}
