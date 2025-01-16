import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ice;
    static int N, K;
    static int sum, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ice = new int[1000001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            ice[x] = g;
        }

        int size = 1 + (K*2);

        for(int i = 0; i < 1000001; i++){
            sum += ice[i];

            if(i >= size)
                sum -= ice[i-size];

            max = Math.max(max, sum);
        }

        System.out.println(max);
        br.close();
    }

}