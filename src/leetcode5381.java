/**
 * Created by xuanmao on 2020/4/12.
 */
public class leetcode5381 {
    public int[] processQueries(int[] queries, int m) {
        int[]  f =new int[m];
        for (int i =0;i<m;i++){
            f[i] = i+1;
        }
        int[] ans = new int[queries.length];
        for (int i =0;i<queries.length;i++){
            int k = queries[i];
            for (int j=0;j<m;j++){
                if (f[j] == k){
                    ans[i] = j;
                    break;
                }
            }
            for (int j=ans[i]-1;j>=0;j--){
                f[j+1] = f[j];
            }
            f[0] = k;
            for (int j=0;j<m;j++){
                System.out.print(f[j]+" ");
            }
            System.out.println();
        }
        return ans;
    }
}
