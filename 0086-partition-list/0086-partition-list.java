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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        ListNode lessTail = lessHead; 
        ListNode greaterTail = greaterHead; 

        ListNode temp = head;

        while(temp!=null){
            if(temp.val<x){
                lessTail.next = temp;
                lessTail = lessTail.next;
            }
            else{
                greaterTail.next = temp;
                greaterTail = greaterTail.next;
            }
            temp = temp.next;
        }
        lessTail.next = greaterHead.next;
        greaterTail.next = null;
        return lessHead.next;
    }
}