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
     *
     * @param number
     * @param name
     * @param checkedOut
     * @param datePublished
     */
    public Book(String number, String name, boolean checkedOut, Date datePublished) {
        this.number = number;
        this.name = name;
        this.checkedOut = checkedOut;
        this.datePublished = datePublished;
    }

    public String getName() {
        return name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public boolean getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    @Override
    public boolean equals(Object obj){
        Book objBook = (Book) obj;
        if (objBook.getNumber().equals(number)) {
            return true;
        }
        return false;
    }

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
