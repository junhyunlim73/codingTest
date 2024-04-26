import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 1;
    static int reverse = 0;
    static String S;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean flag;
    public static void main(String[] args) throws IOException {
        S = br.readLine();
        for(int i = 1; i < S.length(); i++){
            if(S.charAt(i) != S.charAt(i-1) && !flag){
                flag = !flag;
                reverse++;
                cnt++;
            }else if(S.charAt(i) != S.charAt(i-1) && flag){
                flag = !flag;
                cnt++;
            }
        }
        System.out.println(Math.min(reverse, cnt - reverse));
        br.close();
    }
}