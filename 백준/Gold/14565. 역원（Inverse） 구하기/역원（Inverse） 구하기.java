import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N, A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        A = Long.parseLong(st.nextToken());

        B = N - A;
        C = xgcd(N, A);

        System.out.println(B + " " + C);
        br.close();
    }

    private static long xgcd(long r1, long r2) {
        long t1 = 0;
        long t2 = 1;

        while(true){
            if(r2 == 0){
                return r1 == 1 ? (t1 < 0 ? N + t1 : t1) : -1;
            }

            long temp = r1 % r2;
            long p = r1 / r2;
            r1 = r2;
            r2 = temp;

            long temp2 = t1 - (t2 * p);
            t1 = t2;
            t2 = temp2;
        }

    }

}