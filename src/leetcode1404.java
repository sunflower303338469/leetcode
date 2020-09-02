/**
 * Created by xuanmao on 2020/6/8.
 */
public class leetcode1404 {
    public int numSteps(String s) {
        int ans = 0;
        boolean hasOne = false;
        for (int i = s.length()-1;i>0;i--){
            if (hasOne){
                if (s.charAt(i)=='1'){
                    ans+=1;
                } else {
                    ans+=2;
                }
            } else {
                if (s.charAt(i)=='1'){
                    ans+=2;
                    hasOne=true;
                } else {
                    ans+=1;
                }
            }
        }
        if (hasOne){
            ans+=1;
        }
        return ans;
    }
}
