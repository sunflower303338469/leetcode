/**
 * Created by xuanmao on 2019/7/23.
 */
public class leetcode845 {
    public int longestMountain(int[] A) {
        int up = 1;
        int down = 0;
        int ans = 0;
        boolean flag = false;
        for (int i=1;i<A.length;i++){
            if (A[i]>A[i-1]){
                up = up +1;
                down = 0;
                flag = true;
            } else if (flag && (A[i]<A[i-1])){
                if (down == 0){
                    down = up + 1;
                } else {
                    down = down + 1;
                }
                ans = Math.max(down, ans);
                up = 1;
            } else {
                up = 1;
                down = 0;
                flag = false;
            }
        }
        return ans;
    }
}
