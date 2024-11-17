import java.io.*;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] ch = br.readLine().toCharArray();

        for (char c : ch) {
            if (c >= 'A' && c <= 'Z')
                sb.append(c);
            else {
                if (c == '(')
                    stack.push(c);
                else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    if (!stack.isEmpty())
                        stack.pop();
                } else {
                    while (!stack.isEmpty() && opPriority(stack.peek()) >= opPriority(c)) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
        br.close();
    }

    private static int opPriority(char op){
        if(op == '*' || op == '/')
            return 2;
        else if(op == '+' || op == '-')
            return 1;
        else
            return 0;
    }

}