import java.util.Arrays;
import java.util.List;

public class MenuPrinter {

    private static List<String> menuList = Arrays.asList("Choose a status of shown TODO items [IU, IN, NU, NN]",
            "Add item [ADD]", "Mark or unmark item [MARK]", "Remove item [REMOVE]", "Archive all done items [ARCHIVE]",
            "List all items [ALL]", "Save to file [SAVE]", "Load tasks from file [LOAD]", "Exit program [EXIT]");

    public static void printStart(){
        for (int i = 0; i < menuList.size(); i++){
            System.out.println((i+1) + ". " + menuList.get(i));
        }
    }

    public static void printAll(){
        Character[] important = new Character[]{' ', ' ', 'I', 'M', 'P', 'O', 'R', 'T', 'A', 'N', 'T', ' ', ' '};
        Character[] notImportant = new Character[]{'N', 'O', 'T',' ', 'I', 'M', 'P', 'O', 'R', 'T', 'A','N', 'T'};
        String urgent = "URGENT";
        String notUrgent = "NOT URGENT";
        String item1 = "";
        String item2 = "";
        String dash = "---------------------------------------------------------------";
        System.out.println(dash);
        System.out.printf("  |%10s %s %-10s|%8s %s %-8s|  %n", " ", urgent, " ", " ", notUrgent, " ");
        System.out.println(dash);
        for(int i = 0; i < important.length; i++){
            System.out.printf("%c |%-28s|%-28s|  %n",important[i], item1, item2);
        }
        System.out.println(dash);
        for(int i = 0; i < notImportant.length; i++){
            System.out.printf("%c |%-28s|%-28s|  %n",notImportant[i], item1, item2);
        }
        System.out.println(dash);
    }

}