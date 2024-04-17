import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S, cnt;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < 1 << arr.length; i++){
            int sum = 0;
            for(int j = 0; j < arr.length; j++){
                if((i & (1 << j)) != 0)
                    sum += arr[j];
            }
            if(sum == S)
                cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}