import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(!minheap.isEmpty())
                    sb.append(minheap.poll() + "\n");
                else
                    sb.append(0 + "\n");
            }else
                minheap.add(x);
        }
        System.out.println(sb.toString());
        br.close();
    }
}