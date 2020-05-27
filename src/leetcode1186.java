/**
 * Created by xuanmao on 2020/5/10.
 */
public class leetcode1186 {
    public int maximumSum(int[] arr) {
        boolean check = true;
        int a = Integer.MIN_VALUE;
        for (int  i=0;i<arr.length;i++){
            if (arr[i]>=0){
                check = false;
                break;
            }
            a = Math.max(a, arr[i]);
        }
        if (check){
            return a;
        }

        int min = 0;
        if (arr[0]<0){
            min = arr[0];
        }
        int ans = arr[0];
        int now = arr[0];
        int nowNotDel = arr[0];
        for (int i = 1;i<arr.length;i++){
            if (nowNotDel<0){
                nowNotDel = 0;
            }
            nowNotDel = nowNotDel+arr[i];
            now = now+arr[i];
            if (arr[i]<0){
                if (min>arr[i]){
                    min = arr[i];
                }
                if (now-min<nowNotDel-arr[i]){
                    now = nowNotDel;
                    min = arr[i];
                }
            }
            ans = Math.max(ans, now-min);
            ans = Math.max(ans, nowNotDel);
        }

        return ans;
    }
}
