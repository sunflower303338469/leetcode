/**
 * Created by xuanmao on 2020/4/28.
 */
public class leetcode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i=0;i<flowerbed.length;i++){
            if (flowerbed[i]==1){
                continue;
            }
            if ((i>0) && (flowerbed[i-1]==1)){
                continue;
            }
            if ((i<flowerbed.length-1)&& (flowerbed[i+1]==1)){
                continue;
            }
            flowerbed[i] = 1;
            n--;
        }
        return n<=0;
    }
}
