import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class Dated {
    public static void main(String[] args)  throws ParseException {
        Scanner keyboard = new Scanner(System.in);
        // Initialize simple format
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

        //Set up formatters so that you can use them later
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter dMYF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter shortMonthFormat = DateTimeFormatter.ofPattern("MMM dd yyyy");
        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        //Prompt user to enter the date:
        String userD;
        System.out.println("Enter today's date: ");
        userD = keyboard.next();
        Date date1 = sdf.parse(userD);
        Date today = Calendar.getInstance().getTime();
        System.out.println(today.toString());

        while (date1.compareTo(today) > 0)
        {
            System.out.println("Enter today's date: ");
            userD = keyboard.next();
            date1 = sdf.parse(userD);
        }
        LocalDate userDate=null;
        userDate = LocalDate.parse(userD,dTF);

        //This is how you parse a string with a date time formatter
        System.out.println("This date is presented as day, Month,Year");
        System.out.println(userDate.format(longFormat));
        System.out.println("This date is presented as Month,day, Year");
        System.out.println(userDate.format(shortMonthFormat));
        System.out.println("This date is presented as Month (2 digit),Year");
        System.out.println(userDate.format(dMYF));

    }
}
