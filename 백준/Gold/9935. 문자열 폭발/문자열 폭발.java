import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static char[] ch;
    static String bomb;
    static ArrayDeque<Character> stack;
    static ArrayDeque<Character> in;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ch = br.readLine().toCharArray();
        bomb = br.readLine();
        int len = bomb.length();
        char last = bomb.charAt(len - 1);

        stack = new ArrayDeque<>();
        in = new ArrayDeque<>();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == last) {
                if(!isChecked(len)){
                    while(!in.isEmpty()){
                        stack.push(in.pop());
                    }
                    stack.push(ch[i]);
                }
            }else{
                stack.push(ch[i]);
            }
        }

        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            while(!stack.isEmpty()){
                sb.append(stack.removeLast());
            }
            System.out.println(sb);
        }

        br.close();
    }

    private static boolean isChecked(int len){
        if(stack.isEmpty() && len == 1)
            return true;
        
        for(int i = len - 2; i >= 0; i--){
            if(!stack.isEmpty() && bomb.charAt(i) == stack.peek()){
                in.push(stack.pop());
            }else{
                return false;
            }
        }

        in.clear();
        return true;
    }

}