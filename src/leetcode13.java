import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/6/6.
 */
public class leetcode13 {
    public int romanToInt(String s) {

        int ans = 0;
        int pos = 0;
        int before = 0;
        Map<Character,Integer> value = new HashMap<>();
        value.put('I',1);
        value.put('V',5);
        value.put('X',10);
        value.put('L',50);
        value.put('C',100);
        value.put('D',500);
        value.put('M',1000);
        while (pos<s.length()){
            int v = value.get(s.charAt(pos));
            if (v>before){
                ans = ans - 2 * before + v;
            } else {
                ans = ans + v;
            }
            before = v;
            pos+=1;
        }
        return ans;
    }
}
