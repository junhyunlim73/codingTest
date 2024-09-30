import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] isPrime;
    static boolean[] isCheck;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isPrime = new boolean[9001];
        isCheck = new boolean[9001];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        isPrime[0] = isPrime[1] = true;

        for(int i = 2; i <= Math.sqrt(9000); i++) {
            if(!isPrime[i]){
                for(int j = i*i ; j < 9001; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        perm(0, 0, 0);

        if(pq.isEmpty()){
            System.out.print(-1);
        }else{
            while(!pq.isEmpty()){
                System.out.print(pq.poll() + " ");
            }
        }
        br.close();
    }

    private static void perm(int index, int depth, int sum){
        if(depth == M){
            if(!isPrime[sum] && !isCheck[sum]){
                pq.add(sum);
                isCheck[sum] = true;
            }
            return;
        }

        for(int i = index; i < N ; i++){
            perm(i+1, depth+1, sum + arr[i]);
        }

    }

}