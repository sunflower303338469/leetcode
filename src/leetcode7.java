/**
 * Created by xuanmao on 2019/6/12.
 */
public class leetcode7 {
    public int reverse(int x) {
        if (x==0){
            return 0;
        }
        Long xx = Long.valueOf(x);
        StringBuffer stringBuffer = new StringBuffer();
        if (xx<0){
            xx = -xx;
            stringBuffer.append('-');
        }
        while (xx>0){
            stringBuffer.append(xx%10);
            xx =xx/10;
        }
        Long value = Long.valueOf(stringBuffer.toString());
        if ((value>Integer.MAX_VALUE) || (value<Integer.MIN_VALUE)){
            return 0;
        }
        return value.intValue();
    }
}
