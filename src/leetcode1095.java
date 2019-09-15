/**
 * Created by xuanmao on 2019/6/23.
 */
public class leetcode1095 {
    public class MountainArray {
        public int get(int index) {
            return index;
        }

        public int length() {
            return 1;
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int a = mountainArr.get(0);
        int b = mountainArr.get(1);
        int l = 0;
        int r = mountainArr.length();
        int t1;
        int t2;
        int tag = 0;
        if (a > b) {
            tag = 1;
        }
        int top = -1;
        while (l < r) {
            int p = (l + r) / 2;
            int pv = mountainArr.get(p);
            if (p-1<0){
                l = p+1;
                continue;
            }
            if (p+1==mountainArr.length()){
                r = p-1;
                continue;
            }
            int pb = mountainArr.get(p-1);
            int pa = mountainArr.get(p+1);
            int tag1 = getTag(pv, pa);
            int tag2 =  getTag(pb, pv);
            if (tag1!= tag2){
                top = p;
                break;
            }
            if (tag1 != tag) {
                r = p-1;
            } else {
                l = p+1;
            }
        }
        if (top == -1){
            top = l;
        }
        System.out.println(top);
        l=0;
        r = top;
        while (l<r){
            int p = (l + r) / 2;
            int pv = mountainArr.get(p);
            if (pv == target){
                return p;
            }
            if (pv>target){
                if (tag==0){
                    l = p+1;
                } else {
                    r = p-1;
                }
            } else {
                if (tag==0){
                    r = p-1;
                } else {
                    l = p+1;
                }
            }
        }
        l = top;
        r = mountainArr.length();
        while (l<r){
            int p = (l + r) / 2;
            int pv = mountainArr.get(p);
            if (pv == target){
                return p;
            }
            if (pv>target){
                if (tag==0){
                    l = p+1;
                } else {
                    r = p-1;
                }
            } else {
                if (tag==0){
                    r = p-1;
                } else {
                    l = p+1;
                }
            }
        }
        return -1;
    }

    private  int getTag(int x, int y){
        if (x>y){
            return 1;
        } else {
            return 0;
        }
    }

}
