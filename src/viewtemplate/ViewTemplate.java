package viewtemplate;

import java.util.Scanner;

public abstract class ViewTemplate {

    protected Scanner scanner = new Scanner(System.in);

    protected ViewTemplate() {
        showPage();
    }

    protected void showHeader() {
        System.out.println("Hello guys!");
        System.out.println("------------");
    }
    protected abstract void showBody();

    protected void showFooter() {
        System.out.println("--------------");
        System.out.println("Let me pass this module!");
    }

    protected void showPage() {
        showHeader();
        showBody();
        showFooter();
    }
}
