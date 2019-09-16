public class leetcode1151 {
    public int minSwaps(int[] data) {
        if (data.length==0){
            return 0;
        }
        int oneCount = 0;
        int[] f = new int[data.length];
        f[0]=  data[0];
        for (int i=0;i<data.length;i++){
            if (i!=0){
                f[i]= f[i-1]+data[i];
            }
            oneCount += data[i];
        }
        int ans =data.length;
        if (oneCount==0){
            return 0;
        }
        for (int i =oneCount-1;i<data.length;i++){
            if (i==oneCount-1){
                ans = Math.min(ans, oneCount-f[i]);
            } else {
                ans = Math.min(ans, oneCount-(f[i]-f[i-(oneCount-1)]));
            }
        }
        return ans;
    }
}
