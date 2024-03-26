import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            deque.add(i);
        }

        while(deque.size() != 1){
            deque.poll();
            deque.add(deque.poll());
        }
        System.out.println(deque.peek());
    }
}