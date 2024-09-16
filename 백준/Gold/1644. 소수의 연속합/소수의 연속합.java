import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static boolean[] isPrime;
    static int N;
    static ArrayList<Integer> list;
    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        isPrime = new boolean[N + 1];
        list = new ArrayList<>();

        for(int i = 2; i <= Math.sqrt(N); i++){
            if(!isPrime[i]){
                for(int j = i * i; j <= N; j += i){
                    isPrime[j] = true;
                }
            }
        }

        for(int i = 2; i <= N; i++){
            if(!isPrime[i]){
                list.add(i);
            }
        }

        int cnt = 0;
        int sum = 0;

        if(list.size() != 0)
            sum = list.get(end);

        while(end < list.size()){
            if(sum <= N){
                
                if(sum == N)
                    cnt++;
                end++;
                
                if(end < list.size())
                    sum += list.get(end);
            } else{
                sum -= list.get(start);
                start++;
            }
        }

        System.out.println(cnt);
        br.close();
    }

}