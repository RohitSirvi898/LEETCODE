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
        int curr=0;
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        while(l1!=null && l2!=null){
            temp.next=new ListNode(l1.val+l2.val);
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
            if(curr==1){
                temp.val++;
                curr=0;
            }
            if(temp.val>=10){
                temp.val=temp.val%10;
                curr=1;
            }
        }
        while(l1!=null){
            temp.next=new ListNode(l1.val);
            temp=temp.next;
            l1=l1.next;
            if(curr==1){
                temp.val++;
                curr=0;
            }
            if(temp.val>=10){
                temp.val=temp.val%10;
                curr=1;
            }
        }
        while(l2!=null){
            temp.next=new ListNode(l2.val);
            temp=temp.next;
            l2=l2.next;
            if(curr==1){
                temp.val++;
                curr=0;
            }
            if(temp.val>=10){
                temp.val=temp.val%10;
                curr=1;
            }
        }
        if(curr==1){
            temp.next=new ListNode(1);
        }
        return ans.next;
    }
}