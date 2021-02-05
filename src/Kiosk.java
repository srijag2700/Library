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
                String newBookTitle = tokens[1];
                Date newBookDatePublished = new Date(tokens[2]);
                if (!newBookDatePublished.isValid()) {
                    System.out.println("Invalid date!");
                }
                else {
                    Book newBook = new Book("0", newBookTitle, false, newBookDatePublished);
                    lib.add(newBook);
                    System.out.println(newBookTitle + " was added to the library.");
                }
            }
            else if (command.equals("R")) {
                //do remove
                String serialNum = tokens[1];
                Book tempBook = new Book(tokens[1], "0", false, new Date());
                if (lib.remove(tempBook)) {
                    System.out.println("Book#" + serialNum + " removed.");
                }
                else {
                    System.out.println("Unable to remove, the library does not have this book.");
                }
            }
            else if (command.equals("O")) {
                //do check out
                String serialNum = tokens[1];
                Book tempBook = new Book(tokens[1], "0", false, new Date());
                if (lib.checkOut(tempBook)) {
                    System.out.println("You've checked out Book#" + serialNum + ". Enjoy!");
                }
                else {
                    System.out.println("Book#" + serialNum + " is not available.");
                }
            }
            else if (command.equals("I")) {
                //do return
                String serialNum = tokens[1];
                Book tempBook = new Book(tokens[1], "0", false, new Date());
                if (lib.returns(tempBook)) {
                    System.out.println("Book#" + serialNum + " return has completed. Thanks!");
                }
                else {
                    System.out.println("Unable to return Book#" + serialNum + ".");
                }
            }
            else if (command.equals("PA")) {
                //do print all
                lib.print();
            }
            else if (command.equals("PD")) {
                //do print by dates
                lib.printByDate();
            }
            else if (command.equals("PN")) {
                //do print by numbers
                lib.printByNumber();
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
