import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/11/16.
 */
public class leetcode1352 {
    class ProductOfNumbers {

        List<Long> numList;
        public ProductOfNumbers() {
            numList = new ArrayList<>();
        }

        public void add(int num) {
            if (num == 0){
                numList = new ArrayList<>();
            } else {
                if (numList.isEmpty()){
                    numList.add(Long.valueOf(num));
                } else {
                    numList.add(numList.get(numList.size()-1)*num);
                }
            }
        }

        public int getProduct(int k) {
            if (k == numList.size()){
                return numList.get(numList.size()-1).intValue();
            } else if (k>numList.size()){
                return 0;
            } else {
                return (int)(numList.get(numList.size()-1)/numList.get(numList.size()-k-1));
            }
        }
    }
}
