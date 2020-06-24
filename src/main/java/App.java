import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class App {
   private static Scanner scan;
   private static String choice;
   static UserMenu userMenu = new UserMenu();
   static MenuPrinter menuPrinter = new MenuPrinter();



   public void run() {

       do {
           InputMenu.clear();
           scan = new Scanner(System.in);
           scan.useDelimiter(System.lineSeparator());
           MenuPrinter.printStart();
           choice = UserMenu.getUserChoice();
           UserMenu.runUserChoice(choice);
       } while (!choice.equals("EXIT"));
   }
}





