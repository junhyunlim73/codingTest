import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long M;
    static long[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        long end = 0;
        long start = 0;

        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
            end = Math.max(end, arr[i]);
        }

        while(start <= end){
            long mid = (start + end) / 2;
            long sum = 0;

            for(long num : arr){
                if(num >= mid)
                    sum += num - mid;
            }

            if(sum < M){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(start - 1);
        br.close();
    }
}