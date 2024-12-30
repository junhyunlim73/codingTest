import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean flag = false;

        for(char c : arr) {
            if(!flag){
                if(c == '<'){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    flag = true;
                    sb.append(c);
                }else if(c == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                }else{
                    stack.push(c);
                }
            }else{
                if(c == '>'){
                    flag = false;
                    sb.append(c);
                }else{
                    sb.append(c);
                }
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
        br.close();
    }

}