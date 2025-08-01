
public class LinkedList {
    
    public static class Node{
        int data;
        Node next;
        Node(int data1,Node next1){
            data = data1;
            next = next1;
        }
        Node(int data1){
            data = data1;
            next = null;
        }
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
    private static Node oddEvenList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node odd = head;
        Node even = head.next;
        Node evenNode = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenNode;
        return head;
    }
    private static Node sortList(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node mid = getMid(head);
        Node right = mid.next;
        mid.next = null;
        Node left = head;
        left = sortList(left);
        right = sortList(right);
        return merge(left,right);
    }
    private static Node getMid(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static Node merge(Node left,Node right){
        Node dummy = new Node(0);
        Node temp = dummy;
        while(left != null && right != null){
            if(left.data < right.data){
                temp.next = left;
                left = left.next;
            }
            else{
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left != null) {
            temp.next = left;
        } else {
            temp.next = right;
        }
        return dummy.next;
    }
    private static Node segregate(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node zerodummy = new Node(0);
        Node onedummy = new Node(0);
        Node twodummy = new Node(0);
        Node zero = zerodummy;
        Node one = onedummy;
        Node two = twodummy;
        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }
            else{
                two.next = temp;
                two = two.next;
            }
            temp = temp.next; 
        }
        zero.next = (onedummy.next != null) ? (onedummy.next) : (twodummy.next);
        one.next = twodummy.next;
        two.next = null;
        return zerodummy.next;
    }
    private static Node twoSum(Node head1,Node head2){
        Node dummy = new Node(0);
        Node curr = dummy;
        Node t1 = head1;
        Node t2 = head2;
        int carry = 0;
        while(t1 != null || t2 != null){
            int x = (t1 != null) ? t1.data : 0;
            int y = (t2 != null) ? t2.data : 0;
            int sum = carry + x + y;
            carry = sum/10;
            Node newNode = new Node(sum % 10);
            curr.next = newNode;
            curr = curr.next;
            if(t1 != null){
                t1 = t1.next;
            }
            if(t2 != null){
                t2 = t2.next;
            }
        }
        if(carry > 0){
            curr.next = new Node(carry);
        }
        return dummy.next;
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

    private static Node loopbreak(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                Node entry = head;
                Node prev =  null;
                while(slow != entry){
                    prev = entry;
                    slow = slow.next;
                    entry = entry.next;
                }
                prev.next = null;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6,head.next.next);
        head = loopbreak(head);
        printList(head);
    }
}

