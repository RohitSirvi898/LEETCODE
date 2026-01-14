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
    public ListNode mergesort(ListNode left, ListNode right){
        ListNode temp=new ListNode(0);
        ListNode node=temp;
        while(left!=null && right!=null){
            if(left.val<right.val){
                temp.next=left;
                left=left.next;
            }
            else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }
        if(left!=null){
            temp.next=left;
        }
        else if(right!=null){
            temp.next=right;
        }
        return node.next;
    }

    public ListNode findmiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode middle = findmiddle(head);
        
        ListNode right=sortList(middle.next);
        middle.next=null;
        ListNode left=sortList(head);

        return mergesort(left,right);
    }
}