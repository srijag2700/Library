import java.util.Scanner;
//import java.util.StringTokenizer;

public class Kiosk {
    Library lib = new Library();
    Scanner sc = new Scanner(System.in);
    String input = "";

    public void run() {
        System.out.println(("Library Kiosk running."));
        do {
            input = sc.nextLine();
            if (input.equals("Q")) {
                System.out.println("Kiosk session ended.");
                return;
            }

            //tokenize input
            String[] tokens = input.split(",");
            String command = tokens[0];

            if (command.equals("A")) {
                //do add
            }
            else if (command.equals("R")) {
                //do remove
            }
            else if (command.equals("O")) {
                //do check out
            }
            else if (command.equals("I")) {
                //do return
            }
            else if (command.equals("PA")) {
                //do print all
            }
            else if (command.equals("PD")) {
                //do print by dates
            }
            else if (command.equals("PN")) {
                //do print by numbers
            }
            else {
                //invalid
                System.out.println("Invalid command!");
            }
        }
        while (!input.equals("Q"));
        System.out.println("Kiosk session ended.");
        return;
    }
}
