import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/4/5.
 */
public class leetcode1017 {
    public String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder();
        if (N==0){
            return "0";
        }
        List<Integer> integerList = new ArrayList<>();
        while (N!=0){
            integerList.add(N%2);
            N = N/2;
        }
        for (int i=0;i<integerList.size();i++){
            if (integerList.get(i)==2){
                integerList.set(i,0);
                if (i==integerList.size()-1){
                    integerList.add(1);
                } else {
                    integerList.set(i+1, integerList.get(i+1)+1);
                }
            }
            if (i%2==1){
                if (integerList.get(i)==1){
                    if (i==integerList.size()-1){
                        integerList.add(1);
                    } else {
                        integerList.set(i+1, integerList.get(i+1)+1);
                    }
                }
            }
            sb.append(integerList.get(i));
        }
        sb.reverse();
        return sb.toString();
    }
}
