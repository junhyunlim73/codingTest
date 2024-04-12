import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int i, j;
    static int[] arr;
    static int[] S;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        S = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int k = 1; k < N + 1 ; k++){
            arr[k] = Integer.parseInt(st.nextToken());
            S[k] = S[k-1] + arr[k];
        }
        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            sb.append((S[j] - S[i-1]) + "\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}