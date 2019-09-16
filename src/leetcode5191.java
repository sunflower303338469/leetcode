/**
 * Created by xuanmao on 2019/9/15.
 */
public class leetcode5191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int modd = 1000000007;
        long ans=0;
        int[] v = new int[arr.length*3];
        for (int i =0;i<arr.length;i++){
            v[i] = arr[i];
            if (k>1){
                v[i+arr.length] = arr[i];
            }
            if (k>2){
                v[i+arr.length*2] = arr[i];
            }
        }
        long sum = 0;
        long p = 0;
        for (int i=0;i<v.length;i++){
            sum = sum+v[i];
            p = p+v[i];
            if (sum <0){
                sum = 0;
            }
            ans = Math.max(ans, sum);
        }
        if ((p>0) && (k>3)){
            p = 0;
            for (int i=0;i<arr.length;i++){
                p = p+arr[i];
            }
            int l= 0 ;
            int su = 0;
            for (int i=arr.length-1;i>=0;i--){
                su = su+arr[i];
                l=Math.max(l, su);
            }
            int r= 0 ;
            su = 0;
            for (int i=0;i<arr.length;i++){
                su = su+arr[i];
                r=Math.max(r, su);
            }
            long kv = p *(k-3)+l+r;
            ans = Math.max(ans, kv);

        }
        int a = (int)(ans%modd);
        return a;
    }
}
