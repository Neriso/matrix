import java.util.Scanner;

public class InputMenu {
    public static Scanner scan = new Scanner(System.in);
    public static TodoMatrix matrix = new TodoMatrix();

    public static String userInput(String imputTitle) {
        System.out.println(imputTitle);
        String userInput = scan.next().toUpperCase();
        return userInput;
    }
    public static void clear() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void listAll() {
        System.out.println(matrix.toString());
        System.out.println("\nPress enter to back to menu.");
        scan.next();
    }
 
    public static void listAllUi() {
        System.out.println("\n -- IMPORTANT & URGENT -- \n");
        System.out.println(matrix.getQuarter("IU"));
        System.out.println("\nPress enter to back to menu.");
        scan.next();
    }
 
    public static void listAllIn() {
        System.out.println("\n -- IMPORTANT & NOT URGENT -- \n");
        System.out.println(matrix.getQuarter("IN"));
        System.out.println("\nPress enter to back to menu.");
        scan.next();
    }
 
    public static void listAllNu() {
        System.out.println("\n -- NOT IMPORTANT & URGENT -- \n");
        System.out.println(matrix.getQuarter("NU"));
        System.out.println("\nPress enter to back to menu.");
        scan.next();
    }
 
    public static void listAllNn() {
        System.out.println("\n -- NOT IMPORTANT & NOT URGENT -- \n");
        System.out.println(matrix.getQuarter("NN"));
        System.out.println("\nPress enter to back to menu.");
        scan.next();
    }
 
    public static void printExit() {
        System.out.println("\nGood bye.");
    }
    public static void archiveAll() {
        InputMenu.matrix.archiveItems();
    }
 
    public static void saveTofile() {
        InputMenu.matrix.saveItemsToFile("tasks.txt");
    }
 
    public static void loadFromfile() {
        InputMenu.matrix.addItemsFromFile("tasks.txt");
    }

}