import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }

        long M = Long.parseLong(br.readLine());

        while(start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;

            for(int i = 0; i < N; i++){
                if(arr[i] > mid) sum += mid;
                else sum += arr[i];
            }

            if(sum <= M)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(start-1);
        br.close();
    }
}