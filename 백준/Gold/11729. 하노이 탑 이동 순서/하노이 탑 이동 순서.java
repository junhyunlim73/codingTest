import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, cnt;
    static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);
        System.out.println(cnt);
        System.out.print(sb);
        br.close();
    }

    private static void hanoi(int N, int start, int mid, int end){
        if(N == 1){
            cnt++;
            sb.append(start + " " + end).append("\n");
            return;
        }

        hanoi(N-1, start, end, mid);
        sb.append(start + " " + end).append("\n");
        cnt++;
        hanoi(N-1, mid, start, end);
    }

}