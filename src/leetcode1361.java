/**
 * Created by xuanmao on 2021/3/18.
 */
public class leetcode1361 {
    int[] f;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) {
                if (f[leftChild[i]] == leftChild[i]) {
                    if (getFather(i) == leftChild[i]) {
                        return false;
                    }
                    f[leftChild[i]] = i;
                } else {
                    return false;
                }
            }
        }

        for (int i = 0; i < rightChild.length; i++) {
            if (rightChild[i] != -1) {
                if (f[rightChild[i]] == rightChild[i]) {
                    if (getFather(i) == rightChild[i]) {
                        return false;
                    }
                    f[rightChild[i]] = i;
                } else {
                    return false;
                }
            }
        }
        boolean root = false;
        for (int i = 0; i < n; i++) {
            if (f[i] == i){
                if (root){
                    return false;
                }
                root = true;
            }
        }
        return true;
    }

    private int getFather(int index) {
        while (f[index] != index) {
            f[index] = f[f[index]];
            index = f[index];
        }
        return index;
    }
}
