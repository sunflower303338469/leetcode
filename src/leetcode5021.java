public class leetcode5021 {
    public int twoSumLessThanK(int[] A, int K) {
        int min = K;
        for (int i=0;i<A.length;i++){
            for (int j=i+1;j<A.length;j++){
                if (A[i]+A[j]<K){
                    if (K-A[i]-A[j]<min){
                        min = K-A[i]-A[j];
                    }
                }
            }
        }
        if (min == K){
            return -1;
        } else {
            return K-min;
        }
    }
}
