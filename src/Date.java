import java.util.Calendar;
import java.util.StringTokenizer;

public class Date {
    private int year;
    private int month;
    private int day;
    public Date(String date) {
        StringTokenizer split = new StringTokenizer(date, "/");
        int [] dateNumbers = new int[3];
        int index = 0;
        while (split.hasMoreTokens()) {
            dateNumbers[index] = Integer.parseInt(split.nextToken()); // allowed to use Integer.parseInt?
            index++;
        }
        this.year = dateNumbers[2];
        this.month = dateNumbers[0];
        this.day = dateNumbers[1];
    } //taking mm/dd/yyyy and create a Date object
    public Date() {
        Calendar today = Calendar.getInstance();
        this.year = today.get(Calendar.YEAR); // test?
        this.month = today.get(Calendar.MONTH);
        this.day = today.get(Calendar.DAY_OF_MONTH);
    } //create an object with today’s date (see Calendar class)

    public boolean isValid() {
        Calendar currentDate = Calendar.getInstance();
        int currentYear = currentDate.get(Calendar.YEAR);
        if (year < 1900 || year > currentYear) {
            return false;
        }
        Calendar bookDate = Calendar.getInstance();
        bookDate.set(year, month, 1); // ?
        int numberOfDays = bookDate.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (day > numberOfDays || day < 1) {
            return false;
        }
        return true;
    }
}
