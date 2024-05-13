import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] p = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = 0;

        for(int i = 0; i < N; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p);

        for(int i = 0; i < N; i++){
            time += p[i] * (N - i);
        }

        System.out.println(time);
        br.close();
    }
}