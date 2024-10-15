import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long K, C;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Long.parseLong(st.nextToken());
            C = Long.parseLong(st.nextToken());
            long result = 0;

            if(K == 1 && C == 1){
                bw.write(2 + "\n");
                continue;
            }else if(K != 1 && C == 1){
                bw.write(((K+1) <= 1000000000 ? (K+1) : "IMPOSSIBLE") + "\n");
                continue;
            }else if(K == 1 && C != 1){
                bw.write(K + "\n");
                continue;
            }

            if(K == C){
                bw.write("IMPOSSIBLE\n");
            }else {
                result = xgcd(K, C);
                bw.write(((result != -1) && (result <= 1000000000) ? result : "IMPOSSIBLE") + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static long xgcd(long r1, long r2){
        long temp = r1;
        long t1 = 0;
        long t2 = 1;

        while(true){
            if(r2 == 0){
                return r1 == 1 ? (t1 < 0 ? temp + t1 : t1) : -1;
            }

            long r = r1 % r2;
            long p = r1 / r2;
            r1 = r2;
            r2 = r;

            long temp2 = t1 - (p * t2);
            t1 = t2;
            t2 = temp2;
        }

    }

}