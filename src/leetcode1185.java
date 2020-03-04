import java.util.Calendar;
import java.util.Date;

/**
 * Created by xuanmao on 2020/1/13.
 */
public class leetcode1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        if ((month==1) || (month==2)){
            month+=12;
            year-=1;
        }
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return week[(day+1+2*month+3*(month+1)/5+year+year/4-year/100+year/400 )%7];
    }
}
