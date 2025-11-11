import java.util.*;

public class Solution {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            // Handle collision only if moving opposite directions
            while (!st.isEmpty() && st.peek() > 0 && a < 0) {
                int top = st.peek();
                if (Math.abs(top) < Math.abs(a)) {
                    st.pop();  // smaller right-moving asteroid destroyed
                } else if (Math.abs(top) == Math.abs(a)) {
                    st.pop();  // both destroyed
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;  // current one destroyed
                    break;
                }
            }

            if (!destroyed) st.push(a);  // survives
        }

        // Convert stack to array
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--)
            res[i] = st.pop();

        return res;
    }
}
