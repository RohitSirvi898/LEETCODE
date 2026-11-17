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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while(l1!=null || l2!=null){
            if(l1!=null) {
                st1.push(l1.val); 
                l1 = l1.next;
            }
            if(l2!=null) {
                st2.push(l2.val); 
                l2 = l2.next;
            }
        }
        int cary = 0;
        ListNode prev = null;
        while(!st1.isEmpty() || !st2.isEmpty()){
            int sum = cary;
            if(!st1.isEmpty()) sum+=st1.pop();
            if(!st2.isEmpty()) sum+=st2.pop();
            if(sum>9){
                cary = 1;
                sum%=10;
            }
            else cary = 0;
            ListNode head = new ListNode(sum);
            head.next = prev;
            prev = head;
        }
        if(cary==1){
            ListNode head = new ListNode(1);
            head.next = prev;
            prev = head;
        }
        return prev;
    }
}