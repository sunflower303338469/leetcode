/**
 * Created by xuanmao on 2019/6/30.
 */
public class leetcode5120 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int dep = 0;
        for (int i =0;i<seq.length();i++){
            if (seq.charAt(i)=='('){
                dep+=1;
                ans[i] = dep%2;
            }
            if (seq.charAt(i)== ')'){
                ans[i] = dep%2;
                dep-=1;
            }
        }
        return ans;
    }
}
