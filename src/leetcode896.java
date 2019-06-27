/**
 * Created by xuanmao on 2019/6/27.
 */
public class leetcode896 {
    int[] nList = new int[10];
    public boolean reorderedPowerOf2(int N) {
        while (N>0){
            nList[N%10]++;
            N = N/10;
        }
        int i = 1;
        while (i<1000000000){
            if (check(i)){
                return true;
            }
            i = i*2;
        }
        return false;
    }

    private boolean check(int i){
        int[] iList = new int[10];
        while (i>0){
            iList[i%10]++;
            i = i/10;
        }
        for (int t = 0;t<iList.length;t++){
            if (iList[t]!=nList[t]){
                return false;
            }
        }
        return true;
    }
}
