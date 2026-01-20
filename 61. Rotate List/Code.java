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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int n=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            n++;
        }

        k=k%n;
        if(k==0) return head;
        ListNode last=head;
        for(int i=0;i<k;i++){
            last=last.next;
        }
        ListNode newLast=head;
        while(last.next!=null){
            last=last.next;
            newLast=newLast.next;
        }
        ListNode newhead =newLast.next;

        last.next=head;
        newLast.next=null;
        return newhead;
    }
}