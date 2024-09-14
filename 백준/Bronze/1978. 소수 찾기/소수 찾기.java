import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            if(isPrime(arr[i])) // 소수 판정
                cnt++;
        }

        System.out.println(cnt);
        br.close();
    }

    private static boolean isPrime(int n){ //에라토스테네스의 체
        if(n < 2)
            return false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }

        return true;
    }
}