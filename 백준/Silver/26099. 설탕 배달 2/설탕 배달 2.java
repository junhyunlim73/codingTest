import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if(n == 4 || n == 7){ // n이 4와 7일 경우
            System.out.println(-1);
        }else if(n % 5 == 1 || n % 5 == 3){ // 나머지가 1 또는 3일 경우
            System.out.println((n / 5) + 1);
        }else if(n % 5 == 2 || n % 5 == 4){ // 나머지가 2 또는 4일 경우
            System.out.println((n / 5) + 2);
        }else if(n % 5 == 0){ // 나머지가 0일 경우
            System.out.println((n / 5));
        }

        br.close();
    }

}