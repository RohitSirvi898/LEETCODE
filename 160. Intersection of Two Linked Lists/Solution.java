/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int leftcount=0;
        int rightcount=0;
        ListNode left=headA;
        ListNode right=headB;
        while(left!=null){
            leftcount++;
            if(right!=null){
                rightcount++;
                right=right.next;
            }
            left=left.next;
        }
        while(right!=null){
            rightcount++;
            right=right.next;
        }

        ListNode longer=headA;
        ListNode shorter=headB;
        int diff=0;
        if(rightcount>leftcount){
            longer=headB;
            shorter=headA;
            diff=rightcount-leftcount;
        }
        else{
            longer=headA;
            shorter=headB;
            diff=leftcount-rightcount;
        }
        for(int i=0;i<diff;i++){
            longer=longer.next;
        }
        while(longer!=null){
            if(longer==shorter) return longer;
            longer=longer.next;
            shorter=shorter.next;
        }
        return null;
    }
}