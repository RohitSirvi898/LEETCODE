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
    public ListNode oddEvenList(ListNode head) {
        ListNode evenstart = new ListNode(0);
        ListNode oddstart = new ListNode(1);
        ListNode oddend=oddstart;
        ListNode evenend=evenstart;
        ListNode temp=head;
        int count = 0;
        while(temp!=null){
            if(count%2==0){
                evenend.next=temp;
                evenend=temp;
            }
            else{
                oddend.next=temp;
                oddend=temp;
            }
            temp=temp.next;
            count++;
        }

        evenend.next=oddstart.next;
        oddend.next=null;
        return evenstart.next;
    }
}