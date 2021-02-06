/**
 * The Library class is used to represent all of the current books in array format.
 * It includes fields such as the list of books, number of books and starting serial number and
 * methods such as growing the array, adding a book, removing a book, checking out a book, returning
 * a book, printing the list of books in its current order, by date ascending and by serial number ascending.
 * @author Srija Gottiparthi, Catherine Nguyen
 */

public class Library {
    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag
    private final static int STARTING_SERIAL_NUMBER = 10001;
    private final static int NOT_FOUND = -1;
    private final static int CAPACITY = 4;

    /**
     * Initializes a new Library object with array size of 4 and no books.
     */
    public Library() {
        this.books = new Book[CAPACITY];
        numBooks = 0;
    } //default constructor to create an empty bag

    /**
     * Searches through the array iteratively of a given book.
     * @param book
     * @return index of book in array
     */
    private int find(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(book)) {
                return i; // returns index of book
            }
        }
        return NOT_FOUND;
    } // helper method to find a book in the bag

    /**
     * Increases the capacity of the library by four when it is full.
     */
    private void grow() {
        int currentLength = books.length;
        int newLength = currentLength + CAPACITY;

        Book[] tempBooks = new Book[newLength];

        // copy over all current books
        for (int i = 0; i < currentLength; i++) {
            tempBooks[i] = books[i];
        }

        books = tempBooks;

    } // helper method to grow the capacity by 4

    /**
     * Adds a book to the library.
     * @param book given book to be added
     */
    public void add(Book book) {
        // in kiosk, check date
        // generate serial number. constant + numBooks -> make this new STRING using toString
        // set the serial number of the book
        // if numbooks = books.length, then use grow method
        // numbooks always points to next empty spot -- use this as index
        // increment numBooks by one


        if (numBooks == 0) {
            book.setNumber("" + STARTING_SERIAL_NUMBER);
        }
        else {
            int newSerialNumber = findHighestSerialNumber() + 1;
            book.setNumber(Integer.toString(newSerialNumber));
        }

        if (numBooks == books.length) {
            grow();
        }

        books[numBooks] = book;
        numBooks++;
    }

    /**
     * Removes a book from the library.
     * @param book given book to be removed
     * @return true if book is able to be removed, false otherwise
     */
    public boolean remove(Book book) {
        int bookIndex = find(book);
        if (bookIndex == NOT_FOUND) {
            return false;
        }

        Book[] tempBooks = new Book[books.length-1];
        for (int i = 0, j = 0; i < books.length; i++) {
            if (!books[i].equals(book)) {
                tempBooks[j++] = books[i];
            }
        }
        books = tempBooks;
        numBooks--;
        return true;
    }

    /**
     * Checks out a book if it is in the library.
     * @param book given book to be checked out
     * @return true if book is able to be checked out, false otherwise
     */
    public boolean checkOut(Book book) {
        // if book is in library (find) AND its not checked out, set checkedOut to true & return true
        // if book not in library OR its checked out, return false

        int bookLocation = find(book);
        if (bookLocation == NOT_FOUND) {
            return false;
        }

        Book currentBook = books[bookLocation];
        if (currentBook.getCheckedOut() == false) {
            currentBook.setCheckedOut(true);
            return true;
        }
        return false;
    }

    /**
     * Returns a book if it is in the library.
     * @param book given book to be returned.
     * @return true if book is able to be returned, false otherwise
     */
    public boolean returns(Book book) {
        int bookLocation = find(book);
        if (bookLocation == NOT_FOUND) {
            return false;
        }

        Book currentBook = books[bookLocation];
        if (currentBook.getCheckedOut()) {
            currentBook.setCheckedOut(false);
            return true;
        }
        return false;
    }

    /**
     * Prints the list of books in its current order.
     */
    public void print() {
        if (numBooks == 0) {
            System.out.println("Library catalog is empty!");
            return;
        }
        System.out.println("**List of books in the library.");
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println(books[i]);
            }
        }
        System.out.println("**End of list.");
    } //print the list of books in the bag

    /**
     * Prints the list of books sorted by their date published.
     */
    public void printByDate() {
        if (numBooks == 0) {
            System.out.println("Library catalog is empty!");
            return;
        }
        insertionSortByDate();
        System.out.println("**List of books by the dates published.");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
        System.out.println("**End of list.");
    } //print the list of books by datePublished (ascending)

    /**
     * Prints the list of books by their serial number sorted.
     */
    public void printByNumber() {
        if (numBooks == 0) {
            System.out.println("Library catalog is empty!");
            return;
        }
        insertionSortByNumber();
        System.out.println("**List of books by the book numbers.");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
        System.out.println("**End of list.");
    } //print the list of books by number (ascending)

    /**
     * Performs an insertion book on the books array to sort by serial number from lowest to highest.
     */
    private void insertionSortByNumber() {
        for (int i = 0; i < books.length; i++) {
            Book currBook = books[i];
            int currNumber = Integer.parseInt(currBook.getNumber());
            int j = i - 1;
            while (j >= 0 && currNumber < Integer.parseInt(books[j].getNumber())) {
                books[j+1] = books[j];
                j--;
            }
            books[j+1] = currBook;
        }
    }

    // TODO: handle books with same date -- sort those alphabetically

    /**
     * Performs an insertion sort on the books array to sort by date from earliest to latest.
     */
    private void insertionSortByDate() {
        for (int i = 0; i < books.length; i++) {
            Book currBook = books[i];
            String currTitle = books[i].getName();
            Date currDate = currBook.getDatePublished();
            int j = i - 1;
            while (j >= 0 && currDate.compareTo(books[j].getDatePublished()) == -1) {
                books[j+1] = books[j];
                j--;
            }
            books[j+1] = currBook;

        }
    }

    /**
     * Finds the greatest serial number in the books array.
     * @return largest serial number found
     */
    private int findHighestSerialNumber() {
        int largestSerialNumber = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                int currSerialNumber = Integer.parseInt(books[i].getNumber());
                if (largestSerialNumber < currSerialNumber) {
                    largestSerialNumber = currSerialNumber;
                }
            }
        }
        return largestSerialNumber;
    }

}
