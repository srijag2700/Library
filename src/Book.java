/**
 * This class represents a book in the library.
 * A book includes fields such as a unique 5-digit automatically generated serial number, title, whether it
 * is checked out, and its date of publication.
 * @author Catherine Nguyen, Srija Gottiparthi
 */

public class Book {
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    /**
     * Initializes a new Book object with a given serial number, name, availability status, and publication date.
     * @param number the serial number of the book
     * @param name the title of the book
     * @param checkedOut the checked-out status of the book (true if checked out, false otherwise)
     * @param datePublished the publication date of the book
     */
    public Book(String number, String name, boolean checkedOut, Date datePublished) {
        this.number = number;
        this.name = name;
        this.checkedOut = checkedOut;
        this.datePublished = datePublished;
    }

    /**
     * Returns the name of the book.
     * @return the name of the book
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the book's serial number.
     * @param number the given serial number to assign to the book
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Returns the book's serial number.
     * @return the book's serial number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Returns the book's date of publication.
     * @return the book's publication date
     */
    public Date getDatePublished() {
        return datePublished;
    }

    /**
     * Sets the book's checked out status.
     * @param checkedOut true if the book is checked out, false otherwise
     */
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    /**
     * Returns the checked out status of the book.
     * @return true if book is checked out, false otherwise
     */
    public boolean getCheckedOut() {
        return checkedOut;
    }

    /**
     * Compares current Book object to another Book object.
     * Determines equality by checking if the serial numbers of both Books are equal.
     * @param obj the book to compare to
     * @return true if the two Books' serial numbers are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        Book objBook = (Book) obj;
        if (objBook.getNumber().equals(number)) {
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the book.
     * @return string representation of the book.
     */
    @Override
    public String toString() {
        //Book#10007::Design Patterns::5/30/1996::is available.
        //number::name::datePublished::checkedOut

        String availability = "";
        if(checkedOut) {
            availability = "is not available.";
        }
        else {
            availability = "is available.";
        }

        String bookText = "Book#" + number + "::" + name + "::" + datePublished + "::" + availability;
        return bookText;
    }
}
