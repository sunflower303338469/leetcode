import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/5/26.
 */
public class leetcode1054 {
    int[] hash = new int[10001];
    class Barcode{
        int val;
        int num;
    }
    public int[] rearrangeBarcodes(int[] barcodes) {

        for (int i=0;i<barcodes.length;i++){
            hash[barcodes[i]] +=1;
        }
        List<Barcode> barcodeList = new ArrayList<>();
        for (int i=0;i<10001;i++){
            if (hash[i]>0){
                Barcode barcode = new Barcode();
                barcode.num = hash[i];
                barcode.val = i;
                barcodeList.add(barcode);
            }
        }
        System.out.println(barcodeList.size());
        barcodeList.sort(new Comparator<Barcode>() {
            @Override
            public int compare(Barcode o1, Barcode o2) {
                Integer i1 = o1.num;
                Integer i2 = o2.num;
                return  i2.compareTo(i1);
            }
        });
        int[] ans = new int[barcodes.length];
        int pos=0;
        for (Barcode b:barcodeList){
            while ((b.num>0)&&(pos<barcodes.length)){
                System.out.println(pos + " "+ b.val);
                ans[pos] = b.val;
                b.num -=1;
                pos+=2;
            }
            if (pos>=barcodes.length){
                break;
            }
            pos = pos -1;
        }
        pos =0;
        for (Barcode b:barcodeList){
            while ((b.num>0)&&(pos<barcodes.length)){
                if (ans[pos] == 0){
                    System.out.println(pos + " "+ b.val);
                    ans[pos] = b.val;
                    b.num -=1;
                }
                pos+=1;
            }
        }
        return ans;
    }
}
