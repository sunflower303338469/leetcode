/**
 * Created by xuanmao on 2020/7/22.
 */
public class leetcode258 {
    public int addDigits(int num) {
        if (num<10){
            return num;
        }
        int count = 0;
        while (num>0){
            count+=num%10;
            num=num/10;
        }
        return addDigits(count);
    }
}
