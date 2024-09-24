import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i < N+1; i++){
            deque.addLast(i);
        }

        sb.append("<");

        while(deque.size() > 1){

            if(cnt == K){
                sb.append(deque.removeFirst()).append(", ");
                cnt = 1;
            }else{
                deque.addLast(deque.removeFirst());
                cnt++;
            }
        }

        sb.append(deque.removeFirst()).append(">");
        System.out.println(sb);
        br.close();
    }

}