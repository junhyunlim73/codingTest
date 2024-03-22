import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(!stack.isEmpty())
                    stack.pop();
            }else{
                stack.push(num);
            }
        }
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);
        br.close();
    }
}