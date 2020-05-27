/**
 * Created by xuanmao on 2020/4/24.
 */
public class leetcode1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[][] sum = new int[arr.length][32];
        for (int i =0;i<arr.length;i++){
            for (int j=0;j<32;j++){
                if (i!=0){
                    sum[i][j] = sum[i-1][j];
                }
                sum[i][j] += arr[i]%2;
                arr[i] = arr[i]/2;
            }
        }
        for (int i=0;i<queries.length;i++){
            Long value = 0L;
            long k = 1;
            int x  =queries[i][0];
            int y = queries[i][1];
            for (int j =0;j<32;j++){
                int v;
                if (x == 0) {
                    v = sum[y][j];
                } else {
                    v= sum[y][j] - sum[x-1][j];
                }
                if (v%2==1){
                    value = value + k;
                }
                k=k*2;
            }
            ans[i] = value.intValue();
        }
        return ans;
    }
}
