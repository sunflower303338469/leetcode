/**
 * Created by xuanmao on 2020/5/29.
 */
public class leetcode875 {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1;
        int r = 1000000001;
        while (l < r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i =0;i<piles.length;i++) {
                count = count + eat(piles[i],mid);
            }
            if (count<=H){
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    private int eat(int bananas, int k) {
        return bananas % k == 0 ? bananas / k : bananas / k + 1;
    }
}
