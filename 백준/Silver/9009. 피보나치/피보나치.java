import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static long[] fivo;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        fivo = new long[45];
        fivo[0] = 0;
        fivo[1] = 1;

        for(int i = 2; i < 45; i++){
            fivo[i] = fivo[i-1] + fivo[i-2];
        }

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            long n = Long.parseLong(br.readLine());
            Stack<Long> stack = new Stack<>();

            for(int j = 44; j >= 0; j--){
                if(n == 0)
                    break;

                if(fivo[j] <= n){
                    n -= fivo[j];
                    stack.push(fivo[j]);
                }
            }

            while(!stack.isEmpty()){
                sb.append(stack.pop() + " ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}