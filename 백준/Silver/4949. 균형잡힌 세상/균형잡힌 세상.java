import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();

            if(str.equals(".")){
                break;
            }

            Stack<Integer> so = new Stack<>();
            Stack<Integer> dae = new Stack<>();

            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '('){
                    so.push(i);
                }

                if(str.charAt(i) == ')' && !so.isEmpty() && !dae.isEmpty() && so.peek() > dae.peek()){
                    so.pop();
                }else if(str.charAt(i) == ')' && !so.isEmpty() && dae.isEmpty()){
                    so.pop();
                }else if(str.charAt(i) == ')' && so.isEmpty()){
                    so.push(i);
                    break;
                }else if(str.charAt(i) == ')' && !so.isEmpty() && !dae.isEmpty() && so.peek() < dae.peek()){
                    break;
                }

                if(str.charAt(i) == '['){
                    dae.push(i);
                }

                if(str.charAt(i) == ']' && !dae.isEmpty() && !so.isEmpty() && so.peek() < dae.peek()){
                    dae.pop();
                }else if(str.charAt(i) == ']' && !dae.isEmpty() && so.isEmpty()){
                    dae.pop();
                }else if(str.charAt(i) == ']' && dae.isEmpty()){
                    dae.push(i);
                    break;
                }else if(str.charAt(i) == ']' && !so.isEmpty() && !dae.isEmpty() && so.peek() > dae.peek()){
                    break;
                }

            }

            sb.append(so.isEmpty() && dae.isEmpty() ? "yes" : "no").append("\n");
        }

        System.out.println(sb.toString());
         br.close();
    }
}