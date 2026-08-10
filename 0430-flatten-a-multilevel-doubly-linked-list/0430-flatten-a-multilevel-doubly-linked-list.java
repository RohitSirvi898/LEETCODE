/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node makeFlat(Node head){
        Node temp = head;
        Node prev = temp;
        while(temp!=null){
            if(temp.child!=null){
                Node Next = temp.next;
                temp.next = temp.child;
                temp.child.prev = temp;
                Node curr = makeFlat(temp.child);
                temp.child = null;
                curr.next = Next;
                if(Next!=null) Next.prev = curr;
                temp = curr;
            }
            prev = temp;
            temp = temp.next;
        }
        return prev;
    }
    public Node flatten(Node head) {
        makeFlat(head);
        return head;
    }
}