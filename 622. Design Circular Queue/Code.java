class MyCircularQueue {
    int arr[];
    int size;
    int front;
    int rear;
    int count;
    public MyCircularQueue(int k) {
        arr=new int[k];
        count=0;
        size=k;
        front=0;
        rear=-1;
    }
    
    public boolean enQueue(int value) {
        if(!isFull()){
            rear=(rear+1)%size;
            arr[rear]=value;
            count++;
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean deQueue() {
        if(!isEmpty()){
            front=(front+1)%size;
            count--;
            return true;
        }
        else{
            return false;
        }
    }
    
    public int Front() {
        if(!isEmpty()){
            return arr[front];
        }
        else{
            return -1;
        }
    }
    
    public int Rear() {
        if(!isEmpty()){
            return arr[rear];
        }
        else{
            return -1;
        }
    }
    
    public boolean isEmpty() {
        if(count==0){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(count == size){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */