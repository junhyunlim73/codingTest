import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static int avg, target, N;
    static double sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        target = (int) Math.round(N * 0.15);

        for (int i = target; i < (N - target); i++) {
            sum += arr[i];
        }

        int cnt = (N - (2 * target));
        avg = (int) Math.round(sum/cnt);

        System.out.println(avg);
        br.close();
    }

}