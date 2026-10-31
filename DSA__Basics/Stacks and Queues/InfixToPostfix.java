import java.util.Stack;

// TC -> O(N)[the for loop scans for each character] + O(N)[Each operator is pushed into the stack atmost once and popped also atmost once]
// SC -> O(N)[Used temporary stack to store operands] + O(N)[Used StringBuilder to store the postfix Expression]

public class InfixToPostfix {

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

    public static String convert(String s){
        Stack<Character> st = new Stack<>(); // Temporary Stack to store operands
        StringBuilder postfix =  new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            // if operand(A-Z,a-z,0-9), then add in the output(postfix)
            if(Character.isLetterOrDigit(ch)){
                postfix.append(ch);
            }

            // if opening bracket, push it
            else if(ch=='('){
                st.push(ch);
            }

            // If closing bracket, pop until opening bracket is found
            else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    postfix.append(st.pop());
                }
                st.pop(); // Remove opening bracket
            }

            // if operator(^,*,%,/,+,-)
            else{
                while(!st.isEmpty() && st.peek() != '(' &&
                       (precedence(st.peek()) > precedence(ch) ||
                       (precedence(st.peek()) == precedence(ch) && ch != '^'))){ // if the current operand have lower precendence than the st.peek() then we add st.peek() into the output(ans)
                        postfix.append(st.pop());
                       }
                    st.push(ch); // push the current operand into the stack
            }
        }
            // Aftr scanning the entire infix expression, pop all the remaining operands from the stack
            while(!st.isEmpty()){
                postfix.append(st.pop());
            }

        return postfix.toString();
    }

    public static void main(String args[]){
        String str = "a+b*(c^d-e)";
        System.out.println("Infix Expression: " + str);
        System.out.println("Postfix Expression: " + convert(str));
    }
}
