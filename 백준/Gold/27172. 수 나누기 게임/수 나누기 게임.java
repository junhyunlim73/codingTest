import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] isPrime;
    static int N;
    static int[] arr;
    static int[] cnts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        cnts = new int[N];
        isPrime = new int[1000001];

        Arrays.fill(isPrime, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            isPrime[arr[i]] = i;
        }

        for(int i = 0; i < N; i++){
            int idx = arr[i];

            for(int j = idx * 2; j < 1000001; j += idx){

                if(isPrime[j] >= 0){
                    cnts[isPrime[idx]]++;
                    cnts[isPrime[j]]--;
                }
            }
        }

        for(int i = 0; i < N; i++){
            System.out.print(cnts[i] + " ");
        }

        br.close();
    }

}