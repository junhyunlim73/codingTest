import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N;
    static int L;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while((L < 101)){
            long n = -1;
            long num = N;

            for(int i = 1; i < L; i++){
                num -= i;
            }

            if((num % L) == 0 && (num >= 0)){
                n = num / L;
            }

            if(n >= 0){
                for(int i = 0; i < L; i++){
                    sb.append((n+i) + " ");
                }
                break;
            }
            L++;
        }

        if(sb.length() == 0){
            System.out.println(-1);
        }else{
            System.out.println(sb);
        }
        br.close();
    }
}