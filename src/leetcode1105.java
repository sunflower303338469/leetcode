/**
 * Created by xuanmao on 2019/6/30.
 */
public class leetcode1105 {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] f = new int[books.length+1];
        int[] widthSum = new int[books.length+1];
        for (int i =1;i<=books.length;i++){
            widthSum[i] = widthSum[i-1] + books[i-1][0];
        }
        for (int i=1;i<=books.length;i++){
            int height = books[i-1][1];
            f[i] = f[i-1] + books[i-1][1];
            for (int j=i-1;j>=1;j--){
                height = Math.max(height, books[j-1][1]);
                if (widthSum[i] - widthSum[j-1]<=shelf_width){
                    f[i] = Math.min(f[i], f[j-1]+height);
                }
            }
            System.out.println(f[i]);
        }
        return f[books.length];
    }
}
