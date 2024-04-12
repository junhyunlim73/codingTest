import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int acc, max;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] temp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < K + 1; i++){
            acc += temp[i];
        }
        max = acc;
        for(int i = 1; i < N - K + 1; i++){
            acc = acc - temp[i] + temp[i+K];
            max = Math.max(acc, max);
        }
        System.out.println(max);
        br.close();
    }
}