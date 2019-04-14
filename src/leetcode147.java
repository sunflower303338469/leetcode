/**
 * Created by xuanmao on 2019/1/29.
 */
public class leetcode147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode insert = head;
        ListNode result = null;
        while (insert != null){
            ListNode temp = insert.next;
            ListNode match = result;
            ListNode front = null;
            while ((match != null) && (match.val<insert.val)){
                front = match;
                match = match.next;
            }
            if (null == front){
                insert.next = match;
                result = insert;
            } else{
                front.next = insert;
                insert.next = match;
            }
            insert = temp;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
