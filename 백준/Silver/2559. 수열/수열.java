import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int i, j;
    static int max;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] S = new int[N];
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        S[0] = arr[0];
        for(int m = 1; m < N; m++){
            arr[m] = Integer.parseInt(st.nextToken());
            S[m] = S[m-1] + arr[m];
        }
        i = 1;
        j = K;
        max = S[j-1];
        while(j < N){
            max = Math.max(max, S[j] - S[i-1]);
            i++;
            j++;
        }
        System.out.println(max);
        br.close();
    }
}