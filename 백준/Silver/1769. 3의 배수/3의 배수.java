import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String num = br.readLine();
        int cnt = 0;

        while(true) {

            if(num.length() == 1)
                break;

            cnt++;
            long sum = 0;

            for(int i = 0; i < num.length(); i++) {
                sum += Long.parseLong(String.valueOf(num.charAt(i)));
            }

            num = String.valueOf(sum);
        }

        System.out.println(cnt);
        System.out.println(Integer.parseInt(num) % 3 == 0 ? "YES" : "NO");
    }
}