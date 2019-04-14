import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/3/3.
 */
public class leetcode372 {
    public int superPow(int a, int[] b) {
        return Montgomery(a,b,1337);
    }

    private int Montgomery(int a, int[]b, int c){
        int r=1;
        a = a%c;
        while (!isBequal1(b)) {
            if (b[b.length-1] % 2 !=0){
                r = (r*a) %c;
                System.out.println("r "+r);
            }
            a = (a*a) % c;
            System.out.println("a "+a);
            for (int i=0;i<b.length;i++){
                if (i!=b.length-1){
                    b[i+1] += (b[i]%2)*10;
                }
                b[i] = b[i]/2;
            }
        }
        return (r*a) % c;
    }
    private boolean isBequal1(int[] b){
        for (int i=0;i<b.length-1;i++){
            if (b[i]!=0){
                return false;
            }
        }
        if (b[b.length-1] == 1){
            return true;
        }
        return false;
    }
}
