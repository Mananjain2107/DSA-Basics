import java.util.Stack;

public class InfixToPrefix {

    // precedence() method to assign priority to operators so that we know which 
    // operator should be popped from the stack first during infix-to-postfix conversion

    static int precedence(char ch){
        if(ch == '^'){
            return 3;
        }
        if(ch == '/' || ch == '*' || ch == '%'){
            return 2;
        }
        if(ch == '+' || ch == '-'){
            return 1;
        }
        return -1; // all other operands 
    }

    static String convert(String s) {
        // Step 1: Reverse the string and swap opening and closing brackets
        // e.g., (A+B)*C-D+F --> F+D-C*)B+A( --> F+D-C*(B+A)
        
        StringBuilder rev = new StringBuilder(s).reverse(); // Reverse the infix expression

        // Swaping of brackets
        for (int i = 0; i < rev.length(); i++) {
            if (rev.charAt(i) == '(') {
                rev.setCharAt(i, ')');
            } else if (rev.charAt(i) == ')') {
                rev.setCharAt(i, '(');
            }
        }

        // Step 2: Converting infix to postfix expression
        Stack<Character> st = new Stack<Character>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < rev.length(); i++) {
            char ch = rev.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    postfix.append(st.pop());
                }
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                while (!st.isEmpty() && st.peek() != '(' &&
                       (precedence(st.peek()) > precedence(ch) ||
                       (precedence(st.peek()) == precedence(ch) && ch == '^'))) {
                    postfix.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            postfix.append(st.pop());
        }

        // Step 3: After getting the postfix reverse the expression
        // and Hence we get our prefix
        return postfix.reverse().toString();
    }

    public static void main(String args[]){
        String str = "A+B*(C^D-E)^(F+G*H)-I";
        System.out.println("Infix Expression: " + str);
        System.out.println("Prefix Expression: " + convert(str));
    }
}
