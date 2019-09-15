public class tt1 {
    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i=0;i<A.length;i++){
            if (A[i]<min){
                min = A[i];
            }
        }
        int sum =0;
        while (min>0){
            sum = sum + min %10;
            min = min /10;
        }
        if (sum%2==0){
            return 1;
        } else {
            return 0;
        }
    }
}
