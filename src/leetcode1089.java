import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/6/16.
 */
public class leetcode1089 {
    public void duplicateZeros(int[] arr) {
        for (int i=arr.length-1;i>=0;i--){
            if (arr[i]==0){
                for (int j=arr.length-1;j>i;j--){
                    arr[j] = arr[j-1];
                }
            }
        }
    }
}
