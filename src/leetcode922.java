/**
 * Created by xuanmao on 2019/10/22.
 */
public class leetcode922 {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j  =1;
        while ((i<A.length) && (j<A.length)){
            while (i<A.length){
                if (A[i] % 2 ==0){
                    i+=2;
                } else {
                    break;
                }
            }
            while (j<A.length){
                if (A[j] % 2 !=0){
                    j+=2;
                } else {
                    break;
                }
            }
            if ((i<A.length) && (j<A.length)){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}
