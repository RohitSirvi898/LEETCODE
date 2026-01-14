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
    public ListNode reverseKGroup(ListNode head, int k) {
        int arr[]=new int[k];
        ListNode root=head;
        boolean flag=true;
        while(flag && root!=null){
            ListNode temp=root;
            for(int i=0;i<k;i++){
                if(temp==null) {
                    flag=false;
                    break;
                }
                arr[i]=temp.val; 
                temp=temp.next;
            }
            if(flag){
                for(int i=k-1;i>=0;i--){
                    root.val=arr[i];
                    root=root.next;
                }
            }
        }
        return head;
    }
}