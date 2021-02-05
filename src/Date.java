import java.util.Calendar;
import java.util.StringTokenizer;

public class Date implements Comparable{
    private int year;
    private int month;
    private int day;
    public Date(String date) {
        StringTokenizer split = new StringTokenizer(date, "/");
        int [] dateNumbers = new int[3];
        int index = 0;
        while (split.hasMoreTokens()) {
            dateNumbers[index] = Integer.parseInt(split.nextToken());
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

    // TODO: validate months, and look into 3/30/2021 being accepted
    public boolean isValid() {
        Calendar currentDate = Calendar.getInstance();
        int currentYear = currentDate.get(Calendar.YEAR);
        int earliestValidYear = 1900;
        if (year < earliestValidYear || year > currentYear) {
            return false;
        }
        Calendar bookDate = Calendar.getInstance();
        bookDate.set(year, month - 1, 1); // ?
        int numberOfDays = bookDate.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (day > numberOfDays || day < 1) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object obj) {
        Date objDate = (Date) obj;
        if (year > objDate.getYear()) {
            return 1;
        }
        else if (year < objDate.getYear()) {
            return -1;
        }
        else {
            if (month > objDate.getMonth()) {
                return 1;
            }
            else if (month < objDate.getMonth()) {
                return -1;
            }
            else {
                if (day > objDate.getDay()) {
                    return 1;
                }
                else if (day < objDate.getDay()) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public static void main(String[] args) {
        Date date1 = new Date("01/00/2021");
        if (date1.isValid()) {
            System.out.println(date1.month + "/" + date1.day + "/" + date1.year +
                    " is valid (expected result: is not valid)");
        }
        else {
            System.out.println(date1.month + "/" + date1.day + "/" + date1.year +
                    " is not valid (expected result: is not valid)");
        }
        Date date2 = new Date("01/01/1899");
        if (date2.isValid()) {
            System.out.println(date2.month + "/" + date2.day + "/" + date2.year +
                    " is valid (expected result: is not valid)");
        }
        else {
            System.out.println(date2.month + "/" + date2.day + "/" + date2.year +
                    " is not valid (expected result: is not valid)");
        }
        Date date3 = new Date("01/01/1900");
        if (date3.isValid()) {
            System.out.println(date3.month + "/" + date3.day + "/" + date3.year +
                    " is valid (expected result: is valid)");
        }
        else {
            System.out.println(date3.month + "/" + date3.day + "/" + date3.year +
                    " is not valid (expected result: is valid)");
        }
        Date date4 = new Date("01/15/2021");
        if (date4.isValid()) {
            System.out.println(date4.month + "/" + date4.day + "/" + date4.year +
                    " is valid (expected result: is valid)");
        }
        else {
            System.out.println(date4.month + "/" + date4.day + "/" + date4.year +
                    " is not valid (expected result: is valid)");
        }
        Date date5 = new Date("01/32/2020");
        if (date5.isValid()) {
            System.out.println(date5.month + "/" + date5.day + "/" + date5.year +
                    " is valid (expected result: is not valid)");
        }
        else {
            System.out.println(date5.month + "/" + date5.day + "/" + date5.year +
                    " is not valid (expected result: is not valid)");
        }
        Date date6 = new Date("02/29/2020");
        if (date6.isValid()) {
            System.out.println(date6.month + "/" + date6.day + "/" + date6.year +
                    " is valid (expected result: is valid)");
        }
        else {
            System.out.println(date6.month + "/" + date6.day + "/" + date6.year +
                    " is not valid (expected result: is valid)");
        }
        Date date7 = new Date("02/29/2019");
        if (date7.isValid()) {
            System.out.println(date7.month + "/" + date7.day + "/" + date7.year +
                    " is valid (expected result: is not valid)");
        }
        else {
            System.out.println(date7.month + "/" + date7.day + "/" + date7.year +
                    " is not valid (expected result: is not valid)");
        }
        Date date8 = new Date("02/29/1900");
        if (date8.isValid()) {
            System.out.println(date8.month + "/" + date8.day + "/" + date8.year +
                    " is valid (expected result: is not valid)");
        }
        else {
            System.out.println(date8.month + "/" + date8.day + "/" + date8.year +
                    " is not valid (expected result: is not valid)");
        }
        Date date9 = new Date("01/01/2022");
        if (date9.isValid()) {
            System.out.println(date9.month + "/" + date9.day + "/" + date9.year +
                    " is valid (expected result: is not valid)");
        }
        else {
            System.out.println(date9.month + "/" + date9.day + "/" + date9.year +
                    " is not valid (expected result: is not valid)");
        }
    }
}
