/**
 * Created by xuanmao on 2019/3/6.
 */
public class leetcode528 {
    class Solution {
        private int[] a;
        private int sum = 0;

        public Solution(int[] w) {
            a = new int[w.length];
            a[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                a[i] = a[i - 1] + w[i];
            }
            sum = a[w.length-1];
        }

        public int pickIndex() {
            int v = (int)(Math.random()*(sum));
            int l=0;
            int r=a.length-1;
            while (l<r){
                int mid =(l+r)/2;
                if (a[mid]>v){
                    r=mid;
                } else {
                    l = mid+1;
                }
            }
            return r;
        }
    }
}
