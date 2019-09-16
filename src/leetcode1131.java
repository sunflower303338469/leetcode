/**
 * Created by xuanmao on 2019/7/7.
 */
public class leetcode1131 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int ans = 0;
        for (int v1 = -1; v1<=1;v1+=2){
            for (int v2 = -1; v2<=1;v2+=2){
                int min = 1000000000;
                for (int i=0; i<arr1.length;i++){
                    int p = v1*arr1[i]+ v2*arr2[i] + i;
                    min = Math.min(min, p);
                    ans = Math.max(ans, p-min);
                }
            }
        }
        return ans;
    }
}
