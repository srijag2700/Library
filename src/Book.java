public class Book {
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    public Book(String number, String name, boolean checkedOut, Date datePublished) {
        this.number = number;
        this.name = name;
        this.checkedOut = checkedOut;
        this.datePublished = datePublished;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
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
