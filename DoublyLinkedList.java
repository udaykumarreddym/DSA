class Node{
    int data;
    Node next;
    Node back;

    Node(int data1,Node next,Node back){
        this.data = data1;
        this.next = next;
        this.back = back;
    }
    
    Node(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        int[] a = {3,7,5,8,0,1,2,9,4};
        Node head = convert2LL(a);
        printList(head);
    }
    private static Node convert2LL(int[] a){
        Node head = new Node(a[0]);
        Node prev = head;
        for(int i=1;i<a.length;i++){
            Node temp = new Node(a[i],null,prev);
            prev.next = temp;
            prev = prev.next;
        }
        return head;
    }
    private static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        } 
    }
}

