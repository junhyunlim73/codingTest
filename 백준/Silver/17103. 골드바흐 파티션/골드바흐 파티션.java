import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        prime = new boolean[1000001];

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i < 1000001; i++) {
            prime[i] = isPrime(i);
        }

        for(int i = 0; i < T; i++) {
            int cnt = 0;
            int num = Integer.parseInt(br.readLine());

            if(num == 4){
                cnt = 1;
            }else{
                for(int j = 3; j <= (num / 2); j += 2){
                    if(prime[j] && prime[num - j]){
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}