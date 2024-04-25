import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A, B, C;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        long res = 1;
        while(B > 0){
            if(B % 2 == 1)
                res = ((res % C) * (A % C) )% C;
            A = ((A % C) * (A % C)) % C;
            B /= 2;
        }
        System.out.println(res % C);
        br.close();
    }
    
}