import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            while(true){
                if(!stack.isEmpty()){
                   int top = stack.peek();
                   if(num < top){
                       sb.append(index.peek() + " ");
                       stack.push(num);
                       index.push(i);
                       break;
                   }else{
                       stack.pop();
                       index.pop();
                   }
                }else{
                    sb.append("0 ");
                    stack.push(num);
                    index.push(i);
                    break;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

}