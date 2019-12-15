/**
 * Created by xuanmao on 2019/10/13.
 */
public class leetcode5222 {
    public int balancedStringSplit(String s) {
        int l = 0;
        int r = 0;
        int ans = 0;
        for (int i =0;i<s.length();i++){
            if (s.charAt(i)== 'R'){
                r++;
            } else {
                l++;
            }
            if (l==r){
                ans++;
            }
        }
        return ans;
    }
}
