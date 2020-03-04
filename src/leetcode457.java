/**
 * Created by xuanmao on 2020/2/21.
 */
public class leetcode457 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {

            int[] before = new int[nums.length];
            for (int j = 0; j < before.length; j++) {
                before[j] = -1;
            }
            int nowIndex = i;
            while (true) {

                int afterIndex = ((nowIndex + nums[nowIndex] ) % nums.length + nums.length) % nums.length;
                System.out.println(i+ " " + nowIndex+" "+ afterIndex);
                if (before[afterIndex]!=-1){
                    if ((afterIndex != nowIndex) && (nowIndex == before[afterIndex])) {
                        int index = before[afterIndex];
                        boolean flag=  true;
                        while (index != afterIndex) {
                            System.out.println("while" + i+ " " + index+" "+ afterIndex);
                            if (nums[index] * nums[before[afterIndex]] < 0) {
                               flag=false;
                            }
                            index = before[index];
                        }
                        if (flag){
                            return true;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                before[afterIndex] = nowIndex;
                nowIndex = afterIndex;
            }
        }
        return false;
    }
}
