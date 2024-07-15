import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt_5 = 0;
        int cnt_25 = 0;
        int cnt_125 = 0;

        cnt_5 = N / 5;
        cnt_25 = N / 25;
        cnt_125 = N / 125;
        System.out.println(cnt_5 + cnt_25 + cnt_125);

    }
}