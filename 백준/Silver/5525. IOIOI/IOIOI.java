import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, P, cnt;
    static char[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        ch = br.readLine().toCharArray();
        int num = (2*N) + 1;
        String target = "I" + "OI".repeat(N);
        String str = "";

        for (int i = 0; i < num; i++) {
            str += ch[i];
        }

        if(str.equals(target)) {
            cnt++;
        }

        for(int i = num; i < P; i++){
            str = str.substring(1, num) + ch[i];

            if(str.equals(target)) {
                cnt++;
            }

        }

        System.out.println(cnt);
        br.close();
    }

}