/**
 * Created by xuanmao on 2020/9/1.
 */
public class leetcode1539 {
    public int findKthPositive(int[] arr, int k) {
        int value = 0;
        int index = 0;
        while (k>0){
            value++;
            if ((index<arr.length) && (arr[index]==value)){
                index++;
            } else {
                k--;
            }
        }
        return value;
    }
}
