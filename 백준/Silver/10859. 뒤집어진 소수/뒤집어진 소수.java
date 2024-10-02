import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long N;
    static int[] nums;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());

        if(N == 1){
            System.out.println("no");
            return;
        }

        nums = new int[10];

        for(int i = 0; i < 10; i++){
            if(i == 3 || i == 4 || i == 7)
                nums[i] = -1;
            else if(i == 6)
                nums[i] = 9;
            else if(i == 9)
                nums[i] = 6;
            else
                nums[i] = i;
        }

        long temp = N;

        while(temp > 0){
            int num = (int) (temp % 10);

            if(nums[num] == -1){
                System.out.println("no");
                return;
            }

            if(result != 0)
                result *= 10;

            result += nums[num];
            temp /= 10;
        }

        System.out.println((isPrime(N) && isPrime(result)) ? "yes" : "no");
        br.close();
    }

    private static boolean isPrime(long n){
        if(n == 1)
            return false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }

}