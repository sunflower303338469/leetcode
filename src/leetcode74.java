/**
 * Created by xuanmao on 2019/10/10.
 */
public class leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length-1;
        int n = matrix.length-1;
        if (n<0){
            return false;
        }
        int m = matrix[0].length-1;
        if (m<0){
            return false;
        }
        if ((target<matrix[0][0] ) || (matrix[n][m])<target){
            return false;
        }
        while (l<r){
            int mid = (l+r)/2;
            if (target <matrix[mid][0]){
                r = mid-1;
            } else if (target > matrix[mid][m]){
                l = mid+1;
            } else {
                l = mid;
                r = mid;
            }
        }
        int t = l;
        l = 0;
        r = m;
        while (l<r){
            int mid = (l+r)/2;
            if (target<matrix[t][mid]){
                r = mid-1;
            } else if (target>matrix[t][mid]){
                l = mid +1;
            } else {
                return true;
            }
        }
        return (l==r)&&(matrix[t][l]==target);
    }
}
