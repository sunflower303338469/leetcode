import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2021/3/10.
 */
public class leetcode880 {
    public String decodeAtIndex(String S, int K) {
        long length = 0L;
        long KK = (long)K;
        int index=  -1;
        while (length<K){
            index++;
            if ((S.charAt(index)>='0') && (S.charAt(index)<='9')){
                length = length*(S.charAt(index)-'0');
            } else {
                length++;
            }
        }
        while (((length!=KK) || ((S.charAt(index)>='0') && (S.charAt(index)<='9'))) && (index!=0)){
            if ((S.charAt(index)>='0') && (S.charAt(index)<='9')){
                length = length/(S.charAt(index)-'0');
                KK = KK % length;
                if (KK == 0){
                    KK = length;
                }
            } else {
                length--;
            }
            index--;
        }
        return ""+S.charAt(index);
    }
}
