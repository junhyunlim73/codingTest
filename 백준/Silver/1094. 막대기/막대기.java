import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        String binary = Integer.toBinaryString(X);
        int cnt = 0;

        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') {
                cnt++;
            }
        }


        System.out.println(cnt);
        br.close();
    }

}