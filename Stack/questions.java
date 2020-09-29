import java.util.Stack;

public class questions {
    public static void main(String[] args) {
        solve();
    }

    public static void solve() {

    }

    public static void ngor(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        
        Arrays.fill(ans, -1);
        
        for(int i = 0; i < arr.length; i++) {
            while(st.size() != 0 && arr[st.peek()] < arr[i]) {
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
    }

    public static void ngol(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        
        Arrays.fill(ans, -1);

        for(int i = arr.length - 1; i >= 0; i--) {
            while(st.size() != 0 && arr[st.peek()] < arr[i]) {
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
    }

    public static void nsor(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        
        Arrays.fill(ans, -1);

        for(int i = 0; i < arr.length; i++) {
            while(st.size() != 0 && arr[st.peek()] > arr[i]) {
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
    }

    public static void nsol(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        Arrays.fill(ans, -1);         

        for(int i = arr.length - 1; i >= 0; i--) {
            while(st.size() != 0 && arr[st.peek()] > arr[i]) {
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
    } 
}