import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Long cnt = 0L;
        cnt += N;
        for(int i = 0; i < N; i++){
            A[i] -= B;
            if(A[i] <= 0)
                continue;
            if(A[i] % C == 0)
                cnt += A[i] / C;
            else{
                cnt += A[i] / C + 1;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}