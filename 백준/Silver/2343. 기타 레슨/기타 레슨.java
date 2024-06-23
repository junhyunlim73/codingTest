import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int start = 0;
        int end = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());

            start = Math.max(start, A[i]);
            end += A[i];

        }

        while(start <= end){
            int sum = 0;
            int count = 0;
            int middle = (start + end) / 2;

            for(int i = 0; i < N; i++){
                if(sum + A[i] > middle){
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }

            if(sum != 0)
                count++;

            if(count > M)
                start = middle + 1;
            else
                end = middle - 1;
        }

        System.out.println(start);
        br.close();
    }
}