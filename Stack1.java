import java.util.Stack;

class Stack_1 {
    public static void main(String[] args) {
        String infix = "A+B*(C^D-E)";
        String postfix = infixToPostfix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
    }

    // Priority of operators
    public static int priortity(char c) {
        if (c == '+' || c == '-') return 1;
        else if (c == '*' || c == '/') return 2;
        else if (c == '^') return 3;
        return -1;
    }

    // Infix to Postfix Conversion
    public static String infixToPostfix(String infix) {
        Stack<Character> s = new Stack<>();
        String postfix = "";
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix += c;
            } else if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    postfix += s.pop();
                }
                if (!s.isEmpty()) s.pop(); // pop '('
            } else {
                while (!s.isEmpty() && priortity(s.peek()) >= priortity(c)) {
                    postfix += s.pop();
                }
                s.push(c);
            }
        }
        while (!s.isEmpty()) {
            postfix += s.pop();
        }
        return postfix;
    }

    /*
    // Stack using Array
    class Stack {
        int size = 100;
        int[] arr = new int[size];
        int top = -1;
        void push(int x) {
            top++;
            arr[top] = x;
        }
        int pop() {
            int s = arr[top];
            top--;
            return s;
        }
        int top() {
            return arr[top];
        }
        int size() {
            return top + 1;
        }
        boolean isEmpty() {
            return top == -1;
        }
        void printStack() {
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    // Stack using LinkedList
    class Stack {
        private class StackLinkedList {
            int data;
            StackLinkedList next;
            StackLinkedList(int d) {
                data = d;
                next = null;
            }
        }
        StackLinkedList top = null;
        int size = 0;

        void push(int x) {
            StackLinkedList temp = new StackLinkedList(x);
            temp.next = top;
            top = temp;
            size++;
        }

        int pop() {
            if (top == null) {
                System.out.println("Stack is empty");
                return -1;
            }
            int data = top.data;
            top = top.next;
            size--;
            return data;
        }

        int top() {
            if (top == null) {
                System.out.println("Stack is empty");
                return -1;
            }
            return top.data;
        }

        int size() {
            return size;
        }

        boolean isEmpty() {
            return top == null;
        }

        void printStack() {
            StackLinkedList current = top;
            if (current == null) {
                System.out.println("Stack is empty");
                return;
            }
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Stack using 2 Queues
    class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int size = 0;

        void push(int x) {
            q2.offer(x);
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            size++;
        }

        int pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            size--;
            return q1.poll();
        }

        int top() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return q1.peek();
        }

        int size() {
            return size;
        }

        boolean isEmpty() {
            return q1.isEmpty();
        }

        void printStack() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            for (int item : q1) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    // Stack using 1 Queue
    class Stack {
        Queue<Integer> q = new LinkedList<>();
        int len = 0;

        void push(int x) {
            q.offer(x);
            int size = q.size();
            for (int i = 0; i < size - 1; i++) {
                q.offer(q.poll());
            }
            len++;
        }

        int pop() {
            if (q.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            len--;
            return q.poll();
        }

        int top() {
            if (q.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return q.peek();
        }

        int size() {
            return len;
        }

        boolean isEmpty() {
            return q.isEmpty();
        }

        void printStack() {
            if (q.isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            for (int item : q) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
    */
}
