import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] first = {2,3,5,7};
    static int[] remain = {1,3,5,7,9};
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        perm(0, 0);
        System.out.println(sb);
        br.close();
    }

    static private void perm(int depth, int sum){
        if(depth == N){
            sb.append(sum + "\n");
            return;
        }

        if(depth == 0){
            for(int num : first){
                perm(depth+1, num);
            }
        }else{
            for(int num : remain){
                int temp = sum * 10;
                temp += num;
                if(isPrime(temp)){
                    perm(depth + 1, temp);
                }
            }
        }

    }

    static private boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

}