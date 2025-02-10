import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] primes = {2, 3, 5, 7};
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        perm(0, 0);
        System.out.print(sb);
        br.close();
    }

    private static void perm(int depth, int total){
        if(depth == N){
            sb.append(total).append("\n");
            return;
        }

        if(depth == 0){
            for(int i = 0; i < 4; i++){
              perm(depth + 1, primes[i]);
            }
        }else{
            for(int i = 1; i < 10; i+= 2){
                if(i == 5)
                    continue;

                int sum = total * 10 + i;

                if(isPrime(sum))
                    perm(depth+1, sum);
            }
        }

    }

    private static boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }

        return true;
    }

}