import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/8/9.
 */
public class t4 {
    public String lastSubstring(String s) {
        int maxValue = 0;
        int index1 = 0;
        Integer index2= null;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (maxValue < s.charAt(i) - 'a') {
                maxValue = s.charAt(i) - 'a';
                index1 = i;
                index2 = null; flag = true;

            }
            if (maxValue > s.charAt(i) - 'a'){
                flag = false;
            }
            if (index2!=null){
                int cha = i - index2;
                if (s.charAt(i)> s.charAt(index1+cha)){
                    index1 = index2;
                    index2 = null;
                } else if (s.charAt(i)< s.charAt(index1+cha)){
                    index2 = null;
                }
            }
            if ((maxValue == s.charAt(i) - 'a') && (!flag)) {
                index2 = i;flag=true;
            }
        }
        return s.substring(index1);
    }
}
