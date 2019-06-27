/**
 * Created by xuanmao on 2019/6/23.
 */
public class leetcode1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int now = 0;
        int[] shang=  new int[1001];
        int[] xia = new int[1001];
        for (int i=0;i<trips.length;i++){
            shang[trips[i][1]] += trips[i][0];
            xia[trips[i][2]] += trips[i][0];
        }
        for (int i =1;i<=1000;i++){
            int du = shang[i] - xia[i];
            now = now+du;
            if (now>capacity){
                return false;
            }
        }
        return true;
    }
}
