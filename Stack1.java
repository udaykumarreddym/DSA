import java.util.LinkedList;
import java.util.Queue;
class Stack1{
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(12);
        s.push(23);
        s.push(34);
        System.out.println(s.top());
        s.pop();
        s.printStack();
    }
}
// class Stack{
//     int size = 100;
//     int[] arr = new int[size];
//     int top = -1;
//     void push(int x){
//         top++;
//         arr[top] = x;
//     }
//     int pop(){
//         int s = arr[top];
//         top--;
//         return s;
//     }
//     int top(){
//         return arr[top];
//     }
//     int size(){
//         return top + 1;
//     }
//     boolean isEmpty(){
//         return top == -1;
//     }
//     void printStack(){
//         for(int i = 0; i <= top; i++){
//             System.out.print(arr[i] + " ");
//         }
//         System.out.println();
//     }
// }

// class Stack{
//     private class StackLinkedList{
//         int data;
//         StackLinkedList next;
//         StackLinkedList(int d){
//             data = d;
//             next = null;
//         }
//     }
//     StackLinkedList top = null;
//     int size = 0;
//     void push(int x){
//         StackLinkedList temp = new StackLinkedList(x);
//         temp.next = top;
//         top = temp;
//         size++;
//     }
//     int pop(){
//         if(top == null){
//             System.out.println("Stack is empty");
//             return -1; // or throw an exception
//         }
//         int data = top.data;
//         top = top.next;
//         size--;
//         return data;
//     }
//     int size(){
//         return size;
//     }
//     boolean isEmpty(){
//         return top == null;
//     }
//     int top(){
//         if(top == null){
//             System.out.println("Stack is empty");
//             return -1; // or throw an exception
//         }
//         return top.data;
//     }
//     void printStack(){
//         StackLinkedList current = top;
//         if(current == null){
//             System.out.println("Stack is empty");
//             return;
//         }
//         while(current != null){
//             System.out.print(current.data + " ");
//             current = current.next;
//         }
//         System.out.println();
//     }
// }

// class Stack {
//     Queue<Integer> q1 = new LinkedList<>();
//     Queue<Integer> q2 = new LinkedList<>();
//     int size = 0;
//     void push(int x){
//         q2.offer(x);
//         while(!q1.isEmpty()){
//             q2.offer(q1.poll());
//         }
//         Queue<Integer> temp = q1;
//         q1 = q2;
//         q2 = temp;
//         size++;
//     }
//     int pop(){
//         if(q1.isEmpty()){
//             System.out.println("Stack is empty");
//             return -1; // or throw an exception
//         }
//         size--;
//         return q1.poll();
//     }
//     int top(){
//         if(q1.isEmpty()){
//             System.out.println("Stack is empty");
//             return -1; // or throw an exception
//         }
//         return q1.peek();
//     }   
//     int size(){
//         return size;
//     }
//     boolean isEmpty(){
//         return q1.isEmpty();
//     }
//     void printStack(){
//         if(q1.isEmpty()){
//             System.out.println("Stack is empty");
//             return;
//         }
//         for(int item : q1){
//             System.out.print(item + " ");
//         }
//         System.out.println();
//     }
// }

class Stack{
    Queue<Integer> q = new LinkedList<>();
    int len = 0;
    void push(int x){
        q.offer(x);
        int size = q.size();
        for(int i = 0; i < size - 1; i++){
            q.offer(q.poll());
        }
        len++;
    }
    int pop(){
        if(q.isEmpty()){
            System.out.println("Stack is empty");
            return -1; // or throw an exception
        }
        len--;
        return q.poll();
    }
    int top(){
        if(q.isEmpty()){
            System.out.println("Stack is empty");
            return -1; // or throw an exception
        }
        return q.peek();
    }
    int size(){
        return len;
    }
    boolean isEmpty(){
        return q.isEmpty();
    }
    void printStack(){
        if(q.isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        for(int item : q){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}