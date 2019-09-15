import java.util.regex.Pattern;

/**
 * Created by xuanmao on 2019/6/2.
 */
public class leetcode1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int [] v1 = new int[arr1.length];
        int [] v2 = new int[arr2.length];
        int [] v3 = new int[1300];
        for (int i=0;i<arr1.length;i++){
            v1[arr1.length-1-i] = arr1[i];
        }
        for (int i=0;i<arr2.length;i++){
            v2[arr2.length-1-i] = arr2[i];
        }
        int h = Math.max(arr1.length,arr2.length);
        for (int i=0;i<h;i++){
            if (arr1.length>i){
                v3[i] =v3[i]+v1[i];
            }
            if (arr2.length>i){
                v3[i] = v3[i] +v2[i];
            }
            while (v3[i]>1){
                if (v3[i+1]>0){
                    v3[i] -=2;
                    v3[i+1] -=1;
                } else {
                    v3[i] -=2;
                    v3[i+1] +=1;
                    v3[i+2] +=1;
                }
            }
        }
        int len = 1;
        for (int i=0;i<1300;i++){
            while (v3[i]>1){
                if (v3[i+1]>0){
                    v3[i] -=2;
                    v3[i+1] -=1;
                } else {
                    v3[i] -=2;
                    v3[i+1] +=1;
                    v3[i+2] +=1;
                }
            }
            if (v3[i] !=0){
                len = Math.max(len,i+1);
            }
        }
        int [] ans = new int[len];
        for (int i=0;i<len;i++){
            ans[len-1-i] = v3[i];
        }
        return ans;
    }
}
