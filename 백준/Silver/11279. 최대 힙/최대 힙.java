import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{
    static int N, x;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(!maxheap.isEmpty()){
                    sb.append(maxheap.poll() + "\n");
                }else
                    sb.append(0 + "\n");
            }else
                maxheap.add(x);
        }
        System.out.println(sb.toString());
        br.close();
    }
}