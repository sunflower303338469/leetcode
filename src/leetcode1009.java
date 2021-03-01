/**
 * Created by xuanmao on 2021/1/10.
 */
public class leetcode1009 {
    public int bitwiseComplement(int N) {
        if(N==0){
            return 1;
        }
        int i =1;
        while (i-1<N){
            i = i*2;
        }
        return i-N-1;
    }
}
