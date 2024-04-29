import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine()); //테스트 케이스
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            String[] vps = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            for(String ps : vps){
                if(ps.equals(")")){
                    if(stack.isEmpty()){
                        stack.add(ps);
                        break;
                    }else
                        stack.pop();
                }else
                    stack.add(ps);
            }
            sb.append((stack.isEmpty() ? "YES" : "NO") + "\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}