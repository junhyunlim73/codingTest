import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int tired = 0;
        int total = 0;

        for (int i = 0; i < 24; i++) {
            if((tired + A) > M || tired >= M){
                tired = Math.max(tired - C, 0);
            }else{
                tired += A;
                total += B;
            }
        }

        System.out.println(total);

    }
}