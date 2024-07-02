import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        int chocolate = 1;
        int cnt = 0;

        while(true){
            if(k <= chocolate)
                break;
            chocolate *= 2;
        }
        sb.append(chocolate + " ");

        while(true){
            if(k % chocolate == 0)
                break;
            chocolate /= 2;
            cnt++;
        }

        sb.append(cnt);

        System.out.println(sb);
        br.close();
    }
}