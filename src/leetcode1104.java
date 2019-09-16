/**
 * Created by xuanmao on 2019/6/30.
 */
public class leetcode1104 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ca = new int[num_people];
        int now = 1;
        int index = 0;
        while (candies>0){

            ca[index] += Math.min(now, candies);
            candies = candies - now;
            now = now +1;
            index = (index+1) % num_people;
        }
        return ca;
    }
}
