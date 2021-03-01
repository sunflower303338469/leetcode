/**
 * Created by xuanmao on 2020/11/18.
 */
public class leetcode1603 {
    class ParkingSystem {

        int[] left = new int[4];

        public ParkingSystem(int big, int medium, int small) {
            left[1] = big;
            left[2] = medium;
            left[3] = small;
        }

        public boolean addCar(int carType) {
            if (left[carType]>0){
                left[carType]--;
                return true;
            }
            return false;
        }
    }
}
