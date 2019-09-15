import javax.annotation.PostConstruct;
import java.util.regex.Pattern;

/**
 * Created by xuanmao on 2019/4/19.
 */
public class leetcode551 {
    public boolean checkRecord(String s) {
        int a = 1;
        int l = 2;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == 'A'){
                a = a-1;
                l = 2;
                if (a<0){
                    return false;
                }
            } else if (s.charAt(i) == 'L') {
                l = l-1;
                if (l<0){
                    return false;
                }
            } else {
                l = 2;
            }
        }
        return true;
    }
}
