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
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode Next=head;
        while(Next!=null){
            curr=Next;
            Next=Next.next;
            curr.next=prev;
            prev=curr;
        }
        return curr;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reversehead=reverse(slow.next);
        while(reversehead!=null){
            if(reversehead.val!=head.val) return false;
            reversehead=reversehead.next;
            head=head.next;
        }
        return true;
    }
}