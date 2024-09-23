import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        isPrime = new boolean[1000001];

        isPrime[0] = isPrime[1] = true;

        for(int i = 2; i <= Math.sqrt(1000000); i++) {
            if(!isPrime[i]) {
                for(int j = i*i; j < 1000001; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        while(true){
            n = Integer.parseInt(br.readLine());

            if(n == 0)
                break;

            boolean flag = false;
            int half = n/2;

            for(int i = 3; i <= half; i +=2){
                if(!isPrime[i] && !isPrime[n-i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");
                    flag = true;
                    break;
                }
            }

            if(!flag)
                sb.append("Goldbach's conjecture is wrong.").append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}