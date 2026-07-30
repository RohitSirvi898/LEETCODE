class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
class MyLinkedList {
    ListNode head;
    ListNode tail;
    int size;
    public MyLinkedList() {
        tail = null;
        head = null;
        size=0;
    }
    
    public int get(int index) {
        if(index < 0 || index > size) return -1;
        ListNode temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp==null?-1:temp.val;
    }
    
    public void addAtHead(int val) {
        if(head==null){
            head = new ListNode(val);
            tail=head;
            return;
        }
        ListNode temp = new ListNode(val);
        temp.next = head;
        head = temp;
        size++;
    }
    
    public void addAtTail(int val) {
        if(head==null){
            head = new ListNode(val);
            tail=head;
            return;
        }
        ListNode temp = new ListNode(val);
        tail.next = temp;
        tail = temp;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index==0) {
            addAtHead(val);
            return;
        }
        ListNode temp = head;
        for(int i=1;i<index;i++){
            if(temp!=null){
                temp = temp.next;
            }
        }
        if(temp==null) return;
        ListNode newnode = new ListNode(val);
        newnode.next = temp.next;
        temp.next = newnode;
        if(newnode.next == null){
            tail = newnode;
        }
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index==0){
            if(head==null) return;
            head = head.next;
            if(head==null) tail=null;
            return;
        }
        
        ListNode temp = head;
        for(int i=1;i<index;i++){
            if(temp!=null){
                temp = temp.next;
            }
        }
        if(temp==null || temp.next==null) return;
        ListNode deleteNode = temp.next;
        temp.next = deleteNode.next;

        if(deleteNode == tail){
            tail = temp;
        }
        size--;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */