import java.time.LocalDate;

public class Task7 {
   
public static String findDay(int month, int day, int year) {
return LocalDate.of(year, month, day)
.getDayOfWeek()
.toString();
}
    
}
