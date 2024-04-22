import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int min = 1000000; // 최소값
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        makeOne(N, 0);
        System.out.println(min);
        br.close();
    }

    static void makeOne(int n, int cnt){
        if(n == 1){
            min = Math.min(cnt, min); //최솟값 구하기
            return;
        }

        if(n % 3 == 0 && cnt < min){ // 3으로 나눌수 있으면, 횟수가 min보다 작으면
            makeOne(n / 3, cnt + 1);
        }

        if(n % 2 == 0 && cnt < min){ // 2으로 나눌수 있으면, 횟수가 min보다 작으면
            makeOne(n / 2, cnt + 1);
        }

        if(n > 1 && cnt < min){ // 1이 0보다 크면, 횟수가 min보다 작으면
            makeOne(n - 1, cnt+1);
        }
    }
}