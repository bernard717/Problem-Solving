/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static ListNode ans;
    public ListNode reverseList(ListNode head) {
        recur(null, head);
        
        return ans;
    }
    public void recur(ListNode prev, ListNode now){
        if(now == null){
            ans = prev;
            return;
        }
        ListNode next = now.next;
        now.next = prev;
        recur(now, next);
    }
}
