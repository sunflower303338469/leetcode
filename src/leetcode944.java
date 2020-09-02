/**
 * Created by xuanmao on 2020/7/9.
 */
public class leetcode944 {
    public int minDeletionSize(String[] A) {
        if (A.length==0){
            return 0;
        }
        int ans = 0;
        for (int i =0;i<A[0].length();i++){
            for (int j = 1;j<A.length;j++){
                if (A[j].charAt(i)<A[j-1].charAt(i)){
                    ans++;
                    break;
                }
            }

        }

        return ans;
    }
}
