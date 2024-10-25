import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 2; i < N + 1; i++){
            int temp = i;
            int r = i;

            for(int j = 2; j <= Math.sqrt(i); j++){
                if(r % j == 0){
                    temp = temp - (temp / j);
                }

                while(r % j == 0){
                    r /= j;
                }
            }

            if(r > 1)
                temp = temp - (temp / r);

            result += temp;
        }

        System.out.println(result);
        br.close();
    }


}