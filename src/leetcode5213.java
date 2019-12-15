/**
 * Created by xuanmao on 2019/10/6.
 */
public class leetcode5213 {
    public int minCostToMoveChips(int[] chips) {
        int jishu = 0;
        int oushu = 0;
        for (int i =0;i<chips.length;i++){
            if (chips[i]%2==0){
                oushu++;
            } else {
                jishu++;
            }
        }
        return Math.min(jishu, oushu);
    }
}
