/**
 * Created by xuanmao on 2019/10/23.
 */
public class leetcode240 {
    int[][] mat;
    public boolean searchMatrix(int[][] matrix, int target) {
        mat = matrix;
        if (matrix.length==0){
            return false;
        }
        int i =0;
        while ((i<matrix.length) && (i<matrix[0].length)){
            if (findx(i, target) || (findy(i, target))){
                return true;
            }
            i++;
        }
        return false;
    }

    private boolean findx(int start, int target){
        int l = start;
        int r = mat[0].length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (mat[start][mid]<target){
                l=  mid+1;
            } else if (mat[start][mid]>target){
                r = mid-1;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean findy(int start, int target){
        int l = start;
        int r = mat.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (mat[mid][start]<target){
                l=  mid+1;
            } else if (mat[mid][start]>target){
                r = mid-1;
            } else {
                return true;
            }
        }
        return false;
    }

}
