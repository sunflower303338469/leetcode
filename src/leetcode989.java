import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/8/18.
 */
public class leetcode989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> convertList = new ArrayList<>();
        for (int i=A.length-1;i>=0;i--){
            convertList.add(A[i]);
        }
        convertList.set(0, convertList.get(0)+K);
        int l =0;
        while (convertList.get(l)>=10){
            int temp = convertList.get(l);
            convertList.set(l, temp%10);
            l++;
            if (l<convertList.size()){
                convertList.set(l, convertList.get(l)+ temp/10 );
            } else {
                convertList.add(temp/10 );
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i =convertList.size()-1;i>=0;i--){
            ans.add(convertList.get(i));
        }
        return ans;
    }
}
