package structure;

import structure.presentation.ProductView;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        run(sc);
        sc.close();
    }


    private static void run(Scanner sc){
        // test tính năng
        ProductView.mainMenu(sc);
    }
}
