package views.user.functionview.allsearchview;

import viewtemplate.UserTemplate;

public class SearchUserByIdView extends UserTemplate {
    public SearchUserByIdView(){

    }
    @Override
    protected void showBody() {
        boolean flag = false;
        long id;

        do {
            try {
                System.out.println("Enter views.user's ID to search:");
                id = Long.parseLong(scanner.nextLine());
                if (userManagement.searchId(id) == null) {
                    System.out.printf("User with ID \"%s\" does not exist!!!\n", id);
                    break;
                }else {
                    System.out.println(userManagement.searchId(id));
                }
            } catch (NumberFormatException numberFormatException) {
                System.err.println("Invalid input, re-enter!");
                flag = true;
            }
        } while (flag);
    }
}
