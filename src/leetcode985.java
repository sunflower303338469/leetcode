/**
 * Created by xuanmao on 2019/2/22.
 */
public class leetcode985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int oddSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                oddSum += A[i];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            A[query[1]] = A[query[1]] + query[0];
            if (A[query[1]] % 2 == 0) {
                if (query[0] % 2 == 0) {
                    oddSum += query[0];
                } else {
                    oddSum += A[query[1]];
                }
            } else {
                if (query[0] % 2 != 0) {
                    oddSum -= (A[query[1]] - query[0]);
                }
            }
            ans[i] = oddSum;
        }
        return ans;
    }
}
