import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/11/19.
 */
public class leetcode1234 {
    public int balancedString(String s) {
        int[] count = new int[4];
        int[] now = new int[4];
        for (int i =0;i<s.length();i++){
            if (s.charAt(i)=='Q'){
                count[0]++;
            }
            if (s.charAt(i)=='W'){
                count[1]++;
            }
            if (s.charAt(i)=='E'){
                count[2]++;
            }
            if (s.charAt(i)=='R'){
                count[3]++;
            }
        }
        for (int i =0;i<4;i++){
            count[i] = count[i] - s.length()/4;
        }
        int ans = 9999999;
        int l =0;
        int r =0;
        while (r<=s.length()){
            boolean flag = true;
            for (int i =0;i<4;i++){
                if (count[i]>now[i]){
                    flag = false;
                }
            }
            if (flag){
                ans = Math.min(ans, r-l);
                if (ans==0){
                    break;
                }
                if (s.charAt(l)=='Q'){
                    now[0]--;
                }
                if (s.charAt(l)=='W'){
                    now[1]--;
                }
                if (s.charAt(l)=='E'){
                    now[2]--;
                }
                if (s.charAt(l)=='R'){
                    now[3]--;
                }
                l++;
            } else {
                if (r==s.length()){
                    break;
                }
                if (s.charAt(r)=='Q'){
                    now[0]++;
                }
                if (s.charAt(r)=='W'){
                    now[1]++;
                }
                if (s.charAt(r)=='E'){
                    now[2]++;
                }
                if (s.charAt(r)=='R'){
                    now[3]++;
                }
                r++;
            }
        }
        return ans;
    }
}
