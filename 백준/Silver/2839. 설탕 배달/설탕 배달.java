import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = 5000;
        if(N < 5){
            if(N % 3 == 0)
                min = 1;
            else
                min = -1;
        }else{
            int num = N / 5;
            for(int i = num; i >=0; i--){
                int sugar = N - 5*i;
                if(sugar % 3 == 0){
                    min = Math.min(min, i + (sugar / 3));
                }
            }
        }
        System.out.println(min != 5000 ? min : -1);
        br.close();
    }
}