import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        int sum = 0;

        for(int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 1){
                plus.add(num);
            }else if(num == 1){
                one++;
            }else if(num == 0){
                zero++;
            }else{
                minus.add(num);
            }
        }

        while(plus.size() > 1){
            int num1 = plus.poll();
            int num2 = plus.poll();
            sum += num1 * num2;
        }

        if(!plus.isEmpty())
            sum += plus.poll();

        while(minus.size() > 1){
            int num1 = minus.poll();
            int num2 = minus.poll();
            sum += num1 * num2;
        }

        if(!minus.isEmpty()){
            if(zero == 0)
                sum += minus.poll();
        }

        sum += one;
        System.out.println(sum);
        br.close();
    }
}