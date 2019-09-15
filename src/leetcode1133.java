import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class leetcode1133 {
    public int largestUniqueNumber(int[] A) {
        int [] p = new int [1001];
        for (int i =0;i<A.length;i++){
            p[A[i]]++;
        }
        for (int i=1000;i>=0;i--){
            if (p[i] == 1){
                return i;
            }
        }
        return -1;
    }
}
