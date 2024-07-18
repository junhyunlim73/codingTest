import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int A_len = A.length();
        int B_len = B.length();
        int num = B_len - A_len;
        int min = 50;

        for(int i = 0; i < num + 1; i++){
            int cnt = 0;
            for(int j = 0; j < A_len; j++){
                if(A.charAt(j) != B.charAt(i+j)){
                    cnt++;
                }
            }
            min = Math.min(min, cnt);
        }

        System.out.println(min);
    }
}