import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int num1 = Math.abs(o1);
            int num2 = Math.abs(o2);

            if(num1 == num2){
                return Integer.compare(o1, o2);
            }

            return Integer.compare(num1, num2);
        });

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(pq.isEmpty()){
                    bw.write("0\n");
                }else{
                    bw.write(pq.poll() + "\n");
                }
            }else{
                pq.add(x);
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }

}