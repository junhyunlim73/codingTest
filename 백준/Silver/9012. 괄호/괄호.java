import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();

            if(isVPC(arr)) // True면 YES
                sb.append("YES").append("\n");
            else // 아니면 NO
                sb.append("NO").append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static boolean isVPC(char[] arr){
        int cnt = 0;

        for(char ch : arr){
            if(ch == '(') // cnt 증가
                cnt++;

            else if(cnt == 0) // false 반환
                return false;

            else if(ch == ')'){ // cnt 감소
                cnt--;
            }
        }

        if(cnt == 0)
            return true;
        else
            return false;
    }

}