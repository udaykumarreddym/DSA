import java.util.Stack;
public class StackProblems {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 2, 6, 1, 4, 7};
        int[] ans = nextGreater(arr);
        System.out.println("Next Greater Element: ");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
    public static int[] nextGreater(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1; 
            } else {
                ans[i] = st.peek(); 
            }
            st.push(arr[i]); 
        }
        return ans;
    }
}
