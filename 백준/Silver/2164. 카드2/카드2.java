import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            q.add(i);
        }

        while(q.size() != 1) {
            q.poll();

            if(q.size() == 1) {
                break;
            }

            int x = q.poll();
            q.add(x);
        }
        
        System.out.println(q.poll());
        br.close();
    }

}