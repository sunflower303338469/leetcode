/**
 * Created by xuanmao on 2019/2/22.
 */
public class leetcode476 {
    public int findComplement(int num) {
        int i =1;
        while (i-1<num){
            i = i*2;
        }
        return i-num-1;
    }
}
