import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserMenu {
    public static Scanner scan = new Scanner(System.in);
    public static String choice;
    static InputMenu inputMenu = new InputMenu();

    public static void runUserChoice(String choice2) {
        Map<String, Runnable> commandsMap = new HashMap<>();
        String[] commands = {"ADD", "EXIT", "ALL", "IU", "IN", "NU", "NN", "MARK", "REMOVE", "ARCHIVE", "SAVE", "LOAD"};
        Runnable[] functions = {() -> createItem(), () -> InputMenu.printExit(), () -> InputMenu.listAll(), () -> InputMenu.listAllUi(),
                () -> InputMenu.listAllIn(), () -> InputMenu.listAllNu(), () -> InputMenu.listAllNn(), () -> markItem(), () -> removeItem(), () -> InputMenu.archiveAll(),
                () -> InputMenu.saveTofile(), () -> InputMenu.loadFromfile()};
        for (int index = 0; index < commands.length; index++) {
            commandsMap.put(commands[index], functions[index]);
        }
        commandsMap.get(choice2).run();
    }
 
    public static String getUserChoice() {
        System.out.print("\nProvide Your [choice] : ");
        choice = scan.next();
        return choice.toUpperCase();
    }
 
    public static void createItem() {
        boolean isImportant = false;
        String userTitle = InputMenu.userInput("Enter a title: ");
        String userDate = InputMenu.userInput("Enter a deadline [yyyy-mm-dd]: ");
        String userIsImportant = InputMenu.userInput("Is your item important? [I/N]");
        if (userIsImportant.equalsIgnoreCase("I")) {
            isImportant = true;
        }
 
        InputMenu.matrix.addItem(userTitle, LocalDate.parse(userDate), isImportant);
        System.out.println("\nPress enter to back to menu.");
        scan.next();
    }
 
 
 
    public static void markItem() {
        System.out.println(InputMenu.matrix);
        String userQuarter = InputMenu.userInput("Type in the name of quarter:");
        String userIndex = InputMenu.userInput("Type in the number of task to mark:");
        int userInt = Integer.parseInt(userIndex);
        if (InputMenu.matrix.getQuarter(userQuarter).getItem(userInt - 1).isDone()) {
            InputMenu.matrix.getQuarter(userQuarter).getItem(userInt - 1).unmark();
        } else {
            InputMenu.matrix.getQuarter(userQuarter).getItem(userInt - 1).mark();
        }
        System.out.println("\nPress enter to back to menu.");
        scan.next();
    }
 
    public static void removeItem() {
        System.out.println(InputMenu.matrix.toStringTable());
        String userQuarter = InputMenu.userInput("Type in the name of quarter:");
        String userIndex = InputMenu.userInput("Type in the number of task to mark:");
        int userInt = Integer.parseInt(userIndex);
        InputMenu.matrix.getQuarter(userQuarter).removeItem(userInt - 1);
        System.out.println("\nPress enter to back to menu.");
        scan.next();
 
    }

}