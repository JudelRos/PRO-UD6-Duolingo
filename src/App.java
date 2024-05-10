import java.util.InputMismatchException;
import java.util.Scanner;
import net.duolingo.storage.WordStorage;
import net.duolingo.menu.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        final Scanner SC = new Scanner(System.in);
        WordStorage storage = new WordStorage();
        Menu menu = new Menu();
        do {
            menu.showMenu();
            try {
                int menuSelection = SC.nextInt();
                SC.nextLine(); // Consume newline character

                switch (menuSelection) {
                    case 1:
                        System.out.println("Write the word you want to add to the dictionary.");
                        String lastWord = SC.nextLine();
                        storage.addWord(lastWord);
                        break;
                    case 2:
                        System.out.println("Write the word you want to delete.");
                        String wordToDelete = SC.nextLine();
                        storage.deleteWord(wordToDelete);
                        break;
                    case 3:
                        System.out.println("Write the word you want to check if exists.");
                        String wordToCheck = SC.nextLine();
                        storage.wordExists(wordToCheck);
                        break;
                    case 4:
                        storage.showInitials();
                        break;
                    case 5:
                        System.out.println("Write the initial you want to see the dictionary from.");
                        String initialChosen = SC.nextLine();
                        storage.showWordsByInitial(initialChosen);
                        break;
                    case 0:
                        System.out.println("Thank you for using Duolingo dictionary.");
                        SC.close();
                        return;
                    default:
                        System.out.println("Invalid menu selection. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                SC.nextLine();
            }
        } while (true);
    }
}