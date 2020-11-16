/**
 * Created by xuanmao on 2020/9/20.
 */
public class leetcode914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length<2){
            return false;
        }
        int[] value = new int[10000];
        for (int i=0;i<deck.length;i++){
            value[deck[i]]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i =0;i<10000;i++){
            if (value[i]>0){
                min = Math.min(min, value[i]);
            }
        }
        if (min ==1 ){
            return false;
        }
        for (int i =0;i<10000;i++){
            if (value[i]!=0){
                min = getGcd(value[i], min);
                if (min == 1){
                    return false;
                }
            }
        }
        return true;
    }

    private int getGcd(int x, int y ){
        int r = x % y;
        return r==0? y : getGcd(y, r);
    }
}
