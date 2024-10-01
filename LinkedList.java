

class Node{
    int data;
    Node next;
    
    Node(int data1,Node next1){
        this.data = data1;
        this.next = next1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}
public class LinkedList {
    public static void main(String[] args) {
        int[] a = {4,2,3,1,5,9,0,8,7};
        Node head = convert(a);
        int x = 10;
        //head = removesHead(head);
        //head = removesTail(head);
        //head = deleteK(head, x);
        //head = deleteEl(head, x);
        //search(head,x);
        //length(head);
        //head = insertHead(head, x);
        //head = insertTail(head, x);
        //head = insertPos(head, x, 7);
        //head = insertBeforeVAl(head, x, 3);
        //Problems on LinkedList
        //head = reverse(head);
        //head = middleNode(head);
        //printList(head);
        //boolean isTrue = Loop(head);
        int len = lengthOfLoop(head);
        //boolean isTrue = isPalindrome(head);
        System.out.println(len);
        //print(head);
    }
    
    private static Node convert(int[] a){
        Node head = new Node(a[0]);
        Node mover = head;
        for(int i=1;i<a.length;i++){
            Node temp = new Node(a[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }
    private static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static void print(Node head){
        System.out.println(head.data);
    }
    private static void length(Node head){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        System.out.println("Length of linkedlist: "+count);
    }
    private static void search(Node head,int key){
        Node temp = head;
        int flag = 0;
        while(temp != null){
            if(temp.data == key){
                System.out.println("FOUND");
                flag = 1;
            }
            temp = temp.next;
        }
        if(flag == 0){
            System.out.println("Not FOUND");
        }
    }
    
    private static Node removesHead(Node head){
        if (head == null) return head;
        head = head.next;
        return head;
    }
    private static Node removesTail(Node head){
        if (head == null||head.next == null) return head;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    private static Node deleteK(Node head,int x){
        if(head == null) return null;
        if(x == 1){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == x){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    private static Node deleteEl(Node head,int el){
        if(head == null) return null;
        if(head.data == el){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){
            if(temp.data == el){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    private static Node insertHead(Node head,int val){
        Node temp = new Node(val,head);
        return temp;
    }
    private static Node insertTail(Node head,int val){
        if(head == null){
            return new Node(val);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newN = new Node(val);
        temp.next = newN;
        return head;
    }
    private static Node insertPos(Node head,int el,int pos){
        if(head == null){
            if(pos == 1){
                return new Node(el);
            }
            else{
                return head;
            }
        }
        if(pos == 1){
            return new Node(el,head);
        }
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == pos-1){
                Node n = new Node(el,temp.next);
                temp.next = n;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
    private static Node insertBeforeVAl(Node head,int el,int val){
        if(head == null){
            return head;
        }
        if(head.data == val){
            return new Node(el,head);
        }
        Node temp = head;
        while(temp.next != null){
            if(temp.next.data == val){
                Node n = new Node(el,temp.next);
                temp.next = n;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    //Problems on LinkedList
    
    public static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
    private static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static boolean Loop(Node head){
        if(head == null || head.next == null){
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    private static int lengthOfLoop(Node head){
        Node slow=head,fast=head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return lengthLoop(slow);
            }
        }
        return 0;
    }
    private static int lengthLoop(Node slow){
        Node temp = slow;
        int cnt = 1;
        while(temp.next != slow){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
    private static boolean isPalindrome(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newNode = reverse(slow);
        Node first = head;
        Node second = newNode;
        while(second != null){
            if(first.data != second.data){
                reverse(newNode);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newNode);
        return true;
    }
}

