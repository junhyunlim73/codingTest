import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int X, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prefix = 0;
        int cnt = 1;

        X = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[X];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < X; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            prefix += arr[i];
        }

        int max  = prefix;

        for(int i = N; i < X; i++) {
            prefix = prefix + arr[i] - arr[i - N];

            if(max < prefix) {
                max = prefix;
                cnt = 1;
            }else if(max == prefix) {
                cnt++;
            }
        }

        if(max != 0) {
            System.out.println(max);
            System.out.println(cnt);
        }else{
            System.out.println("SAD");
        }

        br.close();
    }

}