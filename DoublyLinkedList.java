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
        //head = deleteHead(head);
        //head = deleteTail(head);
        //head = deleteKth(head,5);
        //deleteNode(head.next.next.next);
        //head = insertHeadBefore(head, 10);
        //head = insertTailBefore(head, 10);
        //head = insertBeforeKth(head,9,10);
        //insertBeforeNode(head.next.next,10);
        //head = reverseDLL(head);
        head = deleteAllX(head, 9);
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
    private static Node deleteHead(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }
    private static Node deleteTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node prev = tail.back;
        prev.next = null;
        tail.back = null;
        return head;
    }
    private static Node deleteKth(Node head,int k){
        int cnt = 0;
        Node temp = head;
        while(temp != null){
            cnt++;
            if(cnt == k){
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node next1 = temp.next;
        if(prev == null && next1 == null){
            return null;
        }
        else if(prev == null){
            return deleteHead(head);
        }
        else if(next1 == null){
            return deleteTail(head);
        }
        prev.next = next1;
        next1.back = prev;
        temp.next = null;
        temp.back = null;
        return head;
    }
    private static void deleteNode(Node temp){
        Node prev = temp.back;
        Node front = temp.next;
        if(front == null){
            prev.next = null;
            temp.back = null;
            return;
        }
        prev.next = front;
        front.back = prev;
        temp.next = null;
        temp.back = null;
        return;
    }
    private static Node insertHeadBefore(Node head,int data){
        Node newNode = new Node(data,head,null);
        head.back = newNode;
        return newNode;
    }
    private static Node insertTailBefore(Node head,int data){
        if(head.next == null){
            return insertHeadBefore(head, data);
        }
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node prev = tail.back;
        Node newNode = new Node(data,tail,prev);
        prev.next = newNode;
        tail.back = newNode;
        return head;
    }
    private static Node insertBeforeKth(Node head,int k,int data){
        if(k == 1){
            return insertHeadBefore(head, data);
        }
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == k){
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newNode = new Node(data,temp,prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    } 
    private static void insertBeforeNode(Node node,int data){
        Node prev = node.back;
        Node newNode = new Node(data,node,prev);
        prev.next = newNode;
        node.back = newNode;
    }
    private static Node reverseDLL(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node prev = null;
        Node curr = head;
        while(curr != null){
            prev = curr.back;
            curr.back = curr.next;
            curr.next = prev;
            curr = curr.back;
        }
        return prev.back;
    }

    //Problems on Doubly LinkedList
    
    private static Node deleteAllX(Node head, int x){
        Node temp = head;
        while(temp != null){
            if(temp.data == x){
                if(temp == head){
                    head = head.next;
                }
                Node prev1 = temp.back;
                Node next1 = temp.next;
                if(next1 != null) next1.back = prev1;
                if(prev1 != null) prev1.next = next1;
                temp = next1;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
}

