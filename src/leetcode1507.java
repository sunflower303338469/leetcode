import java.util.Arrays;
import java.util.List;

/**
 * Created by xuanmao on 2020/7/30.
 */
public class leetcode1507 {
    public String reformatDate(String date) {
        String[] strings = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(strings[2]);
        sb.append("-");
        List<String> stringList = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        for (int i = 0; i < stringList.size(); i++) {
            if (strings[1].equals(stringList.get(i))) {
                if (i+1<10){
                    sb.append("0");
                }
                sb.append(i + 1);
                sb.append("-");
            }
        }
        int value = 0;
        for (int i =0;i<strings[0].length();i++){
            if ((strings[0].charAt(i)>='0') && (strings[0].charAt(i)<='9')){
                value++;
            }
        }
        if (value<2){
            sb.append("0");
        }
        sb.append(strings[0].substring(0,value));
        return sb.toString();
    }
}
