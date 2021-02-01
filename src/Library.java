public class Library {
    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag

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
        return -1;
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

    }

    public boolean remove(Book book) {

    }

    public boolean checkOut(Book book) {

    }

    public boolean returns(Book book) {

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

    private Book[] insertionSort() {
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
}
