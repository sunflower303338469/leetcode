/**
 * Created by xuanmao on 2020/9/3.
 */
public class leetcode795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int max = getMax(A, R);
        System.out.println("//////");
        int min = getMax(A,L-1);
        return max-min;
    }

    private int getMax(int[] A, int max){
        int start = 0;
        int end = 0;
        int ans = 0;
        while (start<A.length){
            while ((end<A.length) && (A[end]<=max)){
                end++;
            }
            System.out.println("start:"+start+" end:"+end);
            ans = ans + end-start;
            start++;
            end = Math.max(end, start);
        }
        return ans;
    }
}
