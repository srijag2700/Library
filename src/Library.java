public class Library {
    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag
    private final static int STARTING_SERIAL_NUMBER = 10001;
    private final static int NOT_FOUND = -1;

    public Library() {
        this.books = new Book[4];
        numBooks = 0;
    } //default constructor to create an empty bag

    private int find(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(book)) {
                return i; // returns index of book
            }
        }
        return NOT_FOUND;
    } // helper method to find a book in the bag

    private void grow() {
        int currentLength = books.length;
        int newLength = currentLength + 4;

        Book[] tempBooks = new Book[newLength];

        // copy over all current books
        for (int i = 0; i < currentLength; i++) {
            tempBooks[i] = books[i];
        }

        books = tempBooks;

    } // helper method to grow the capacity by 4

    public void add(Book book) {
        // in kiosk, check date
        // generate serial number. constant + numBooks -> make this new STRING using toString
        // set the serial number of the book
        // if numbooks = books.length, then use grow method
        // numbooks always points to next empty spot -- use this as index
        // increment numBooks by one

        int newSerialNumber = STARTING_SERIAL_NUMBER + numBooks;
        book.setNumber(Integer.toString(newSerialNumber));

        if (numBooks == books.length) {
            grow();
        }

        books[numBooks] = book;
        numBooks++;
    }

    public boolean remove(Book book) {
        //
        int bookLocation = findBySerialNumber(book.getNumber());
    }

    public boolean checkOut(Book book) {
        // if book is in library (find) AND its not checked out, set checkedOut to true & return true
        // if book not in library OR its checked out, return false

        int bookLocation = find(book);
        if (bookLocation != NOT_FOUND && book.getCheckedOut() == false) {
            book.setCheckedOut(true);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean returns(Book book) {
        int bookLocation = find(book);
        if (bookLocation != NOT_FOUND && book.getCheckedOut()) {
            book.setCheckedOut(false);
            return true;
        }
        return false;
    }

    public void print() {
        System.out.println("**List of books in the library.");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
        System.out.println("**End of list.");
    } //print the list of books in the bag

    public void printByDate() {

    } //print the list of books by datePublished (ascending)

    public void printByNumber() {
        Book[] booksSortedByNumber = insertionSort();
        System.out.println("**List of books by the book numbers.");
        for (int i = 0; i < booksSortedByNumber.length; i++) {
            System.out.println(books[i]);
        }
        System.out.println("**End of list.");
    } //print the list of books by number (ascending)

    private void insertionSort() {
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
    // finding the most recent serial number in array
    private int findingHighestSerialNumber() {
        int largestSerialNumber = 0;
        for (int i = 0; i < books.length; i++) {
            int currSerialNumber = Integer.parseInt(books[i].getNumber());
            if (largestSerialNumber < currSerialNumber) {
                largestSerialNumber = currSerialNumber;
            }
        }
        return largestSerialNumber;
    }

    private int findBySerialNumber(String serialNumber) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getNumber().equals(serialNumber)) {
                return i; // returns index of book
            }
        }
        return NOT_FOUND;
    }

}
