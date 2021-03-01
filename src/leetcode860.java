/**
 * Created by xuanmao on 2020/11/17.
 */
public class leetcode860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i=0;i<bills.length;i++){
            if (bills[i]==5){
                five++;
            } else if (bills[i]==10){
                if (five==0){
                    return false;
                }
                five--;
                ten++;
            } else{
                if (ten ==0){
                    if (five<3){
                        return false;
                    } else {
                        five -=3;
                    }
                } else {
                    if (five<1){
                        return false;
                    } else {
                        five--;
                        ten--;
                    }
                }
            }
        }
        return true;
    }
}
