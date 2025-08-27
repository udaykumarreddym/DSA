import java.util.Stack;

class Stack_1 {

    // Priority of operators
    public static int priortity(char c) {
        switch (c) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }
            case '^' -> {
                return 3;
            }
            default -> {
            }
        }
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
                if (!s.isEmpty()) s.pop(); 
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

    public static String infixToPrefix(String infix){
        Stack<Character> s = new Stack<>();
        String prefix = "";
        StringBuilder sb = new StringBuilder(infix);
        sb.reverse(); 
        infix = sb.toString();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                prefix += c;
            } else if (c == ')') {
                s.push(c);
            } else if (c == '(') {
                while (!s.isEmpty() && s.peek() != ')') {
                    prefix += s.pop();
                }
                if (!s.isEmpty()) s.pop();
            } else {
                while (!s.isEmpty() && priortity(s.peek()) > priortity(c)) {
                    prefix += s.pop();
                }
                s.push(c);
            }
        }
        while (!s.isEmpty()) {
            prefix += s.pop();
        }
        StringBuilder result = new StringBuilder(prefix);
        result.reverse(); 
        return result.toString();
    }

    public static String removeKdigits (String num,int k){
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        for(char c : stack) {
            result.append(c);
        }
        while(result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0); 
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void nextGreater(int[] arr){
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                System.out.print("-1 ");
            }else{
                System.out.print(arr[st.peek()] + " ");
            }
            st.push(i);
        }
    }

    //Outer loop 0 -> n and inner condition same [Previous Greater]
    //Outer loop same and inner condition >= [Next Smaller]
    //Outer loop 0 -> n and inner condition >= [Previous Smaller]

    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,0,5};
        nextGreater(arr);
    }
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
