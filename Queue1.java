class Queue1 {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.printQueue();
        System.out.println("Front element: " + q.front());
        System.out.println(q.dequeue());
        q.printQueue();
        System.out.println("Front element after dequeue: " + q.front());
        System.out.println(q.dequeue());
        q.printQueue();
    }
}
// public class Queue{
//     int size = 5;
//     int[] queue = new int[size];
//     int currsize = 0;
//     int start = -1;
//     int end = -1;
//     void enqueue(int x){
//         if(currsize == size){
//             System.out.println("Queue is full");
//             return;
//         }
//         else if(currsize == 0){
//             start = 0;
//             end = 0;
//         }else{
//             end = (end + 1) % size;
//         }
//         queue[end] = x;
//         currsize++;
//     }
//     void dequeue(){
//         if(currsize == 0){
//             System.out.println("Queue is empty");
//             return;
//         }else{
//             start = (start + 1)% size;
//             currsize--;
//         }
//     }
//     int front(){
//         if(currsize == 0){
//             System.out.println("Queue is empty");
//             return -1; // or throw an exception
//         }
//         else{
//             return queue[start];
//         }
//     }
//     int size(){
//         return currsize;
//     }
//     boolean isEmpty(){
//         return currsize == 0;
//     }
//     void printQueue(){
//         if(currsize == 0){
//             System.out.println("Queue is empty");
//             return;
//         }
//         for(int i = 0; i < currsize; i++){
//             System.out.print(queue[(start + i) % size] + " ");
//         }
//         System.out.println();
//     }
// }

class QueueNode{
    int data;
    QueueNode next;
    QueueNode(int d){
        data = d;
        next = null;
    }
}
class Queue{
    QueueNode start = null;
    QueueNode end = null;
    int size = 0;
    void enqueue(int x){
        QueueNode temp = new QueueNode(x);
        if(start == null){
            start = end = temp;
            size++;
        }
        else{
            end.next = temp;
            end = temp;
            size++;
        }
    }
    int dequeue(){
        if(start == null){
            System.out.println("Queue is empty");
            return -1; 
        }else{
            int data = start.data;
            start = start.next;
            if(start == null) end = null;
            size--;
            return data;
        }
    }
    int front(){
        if(start == null){
            System.out.println("Queue is empty");
            return -1; // or throw an exception
        }
        return start.data;
    }
    int size(){
        return size;
    }
    boolean isEmpty(){
        return start == null;
    }
    void printQueue(){
        if(start == null){
            System.out.println("Queue is empty");
            return;
        }
        QueueNode temp = start;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
