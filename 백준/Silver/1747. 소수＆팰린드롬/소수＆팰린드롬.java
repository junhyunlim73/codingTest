import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while(true){
            int size = String.valueOf(N).length();
            int[] arr = new int[size];
            int temp = N;
            boolean flag = false;

            for(int i = 0; i < size; i++){
                arr[i] = temp % 10;
                temp /= 10;
            }

            for(int i = 0; i < size/2; i++){
                if(arr[i] != arr[size-i-1]){
                    flag = true;
                    break;
                }
            }

            if(!flag){
                if(isPrime(N))
                    break;
            }

            N++;
        }

        System.out.println(N);
        br.close();
    }

    private static boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        if(num == 1){
            return false;
        }
        return true;
    }
}