import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        long result = 1;

       while(B > 0){
            if((B & 1) == 1) {
                result = ((result % C) * (A % C)) % C;
            }

            A = ((A % C) * (A % C)) % C;
            B >>= 1;
        }

       System.out.println(result);
       br.close();
    }

}