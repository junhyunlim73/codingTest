import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] branch;
    static int start, end, mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        branch = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            branch[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, branch[i]);
        }

        while(start <= end){
            mid = (start + end) / 2;
            long sum = 0;

            for(int i = 0; i < N; i++){
                long num = branch[i] - mid;
                if(num > 0)
                    sum += num;
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