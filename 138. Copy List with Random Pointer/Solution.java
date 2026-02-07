/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node temp = head;
        while(temp!=null){
            Node newNode = new Node(temp.val);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=temp.next.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.random!=null) temp.next.random=temp.random.next;
            temp=temp.next.next;
        }
        Node newHead=head.next;
        Node newtemp=newHead;
        temp=head;
        while(temp!=null){
            temp.next=temp.next.next;
            temp=temp.next;
            if (newtemp.next!=null) newtemp.next=newtemp.next.next;
            newtemp=newtemp.next;
        }
        return newHead;
    }
}