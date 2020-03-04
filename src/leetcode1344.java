/**
 * Created by xuanmao on 2020/2/16.
 */
public class leetcode1344 {
    public double angleClock(int hour, int minutes) {
        if (hour == 12){
            hour = 1;
        }
        double x = 0.5* (hour*60+minutes);
        double y = minutes*6;
        double angel = Math.abs(x-y);
        if (angel>=180){
            angel = 360-angel;
        }
        return angel;
    }
}
