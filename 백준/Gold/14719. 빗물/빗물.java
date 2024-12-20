import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static int[] arr, leftWall, rightWall;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[W];

        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        leftWall = new int[W];
        rightWall = new int[W];

        leftWall[0] = arr[0];
        for (int i = 1; i < W; i++) {
            leftWall[i] = Math.max(leftWall[i - 1], arr[i]);
        }

        rightWall[W - 1] = arr[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightWall[i] = Math.max(rightWall[i + 1], arr[i]);
        }

        for (int i = 1; i < W - 1; i++) {
            int water = Math.min(leftWall[i], rightWall[i]) - arr[i];

            if (water > 0) {
                total += water;
            }
        }

        System.out.println(total);
        br.close();
    }
}