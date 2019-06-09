/**
 * Created by xuanmao on 2019/5/19.
 */
public class leetcode5063 {
    public int lastStoneWeight(int[] stones) {
        int index1 =0;
        int index2 =0;
        int n=0;
        int ans =0;
        while (n<stones.length){
            int max1= 0;
            int max2=0;
            for (int i=0;i<stones.length;i++){
                if (stones[i]>max1){
                    max2 = max1;
                    index2 = index1;
                    max1 = stones[i];
                    index1 = i;
                } else if (stones[i]>max2){
                    max2 = stones[i];
                    index2 =i;
                }
            }
            n = n+1;
            stones[index2] =0;
            stones[index1] = max1 - max2;
            ans = max1;
        }
        return ans;
    }
}
