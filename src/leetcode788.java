/**
 * Created by xuanmao on 2019/4/19.
 */
public class leetcode788 {

    private int[] convert = {0, 0, 1, 0, 0, 1, 1, 0, 0, 1};
    private int[] legal = {1, 1, 1, 0, 0, 1, 1, 0, 1, 1};

    public int rotatedDigits(int N) {
        int ans = 0;
        for (int i=1;i<=N;i++){
            if (check(i)){
                ans++;
            }
        }
        return ans;
    }

    private boolean check(int x){
        boolean flag = false;
        while (x>0){
            int v = x % 10;
            if (legal[v] == 0){
                return false;
            }
            if (convert[v] == 1){
                flag = true;
            }
            x = x /10;
        }
        return flag;
    }
}
