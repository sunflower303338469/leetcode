import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by xuanmao on 2019/1/27.
 */
public class leetcode754 {
    public int reachNumber(int target) {
        if (target<0){
            target = -target;
        }
        double p = (-1 + Math.sqrt(8.0*target+1)) / 2;
        System.out.println(p);
        //向上取整
        double ans = Math.ceil(p);
        int a = (int)ans;
        if ((a*(a+1)/2-target)%2 != 0) {
            if (a % 2 == 1) {
                a = a + 2;
            } else {
                a = a + 1;
            }
        }

        return a;
    }
}
