/**
 * Created by xuanmao on 2019/8/8.
 */
public class leetcode478 {
    class Solution {

        double radius;
        double x;
        double y;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            x = x_center;
            y = y_center;
        }

        public double[] randPoint() {
            //注意半径的随机不能从0到r，要从0到r^2随机后开方，因为是面积微分的随机，不是半径微分的随机。
            double r = Math.sqrt(Math.random() * radius * radius);
            double angle = Math.random() * 2 * Math.PI;
            double yP = r * Math.sin(angle);
            double xP = r * Math.cos(angle);
            double[] point = new double[2];
            point[0] = xP + x;
            point[1] = yP + y;
            return point;
        }
    }

}
