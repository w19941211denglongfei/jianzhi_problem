package day1;
import java.util.Stack;
public class IsPopOrder {
    public static void main(String[] args) {
        int[] pushV = new int[]{1,2,3,4,5};
        int[] popV = new int[]{4,5,3,1,2};
        boolean b = isPopOrder(pushV,popV);
        System.out.println(b);
    }
    public static boolean isPopOrder(int[] pushV,int[] popV) {
        if (pushV == null && popV == null){
            return true;
        }
        if (pushV.length != popV.length){
            return false;
        }
        Stack<Integer> st = new Stack<>();
        int index = 0;
        for (int i = 0; i < popV.length; i++) {
            st.push(pushV[i]);
            while (!st.isEmpty() && st.peek() == popV[index]){
                st.pop();
                index++;
            }
        }
        return st.isEmpty();
    }
}
