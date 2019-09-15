/**
 * Created by xuanmao on 2019/5/26.
 */
public class leetcode1051 {
    public int heightChecker(int[] heights) {
        int [] p = new int[heights.length];
        for (int i=0;i<heights.length;i++){
            p[i] = heights[i];
        }
        for (int i=0;i<heights.length;i++){
            for (int j=i+1;j<heights.length;j++){
                if (p[i]>p[j]){
                    int temp = p[i];
                    p[i] =p[j];
                    p[j] =temp;
                }
            }
        }
        int ans = 0;
        for (int i=0;i<heights.length;i++){
            if (p[i] != heights[i]){
                ans ++;
            }
        }
        return ans;
    }
}
