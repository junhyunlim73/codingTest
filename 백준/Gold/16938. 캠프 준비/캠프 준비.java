import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] sel, arr;
    static int N, L, R, X, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 1; i < N; i++) {
            sel = new int[i+1];
            combi(0, 0, i+1);
        }

        System.out.println(cnt);
        br.close();
    }

    private static void combi(int idx, int depth, int target){
        if(depth == target){
            int sum = 0;
            int sub = 0;

            for(int num : sel){
                sum += num;
            }

            sub = sel[target-1] - sel[0];

            if(sum >= L && sum <= R && sub >= X)
                cnt++;

            return;
        }

        for(int i = idx; i < N; i++){
            sel[depth] = arr[i];
            combi(i+1, depth+1, target);
        }

    }

}