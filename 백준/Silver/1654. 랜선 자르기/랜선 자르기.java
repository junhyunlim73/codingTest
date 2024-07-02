import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] l = new long[k];
        long end = 1L;
        long start = 1L;

        for(int i = 0; i < k; i++){
            l[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, l[i]);
        }

        while(start <= end){
            long mid = (start + end) / 2;
            int cnt = 0;
            for(long num : l){
                cnt += num / mid;
            }

            if(cnt < n){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(start - 1);
        br.close();
    }
}