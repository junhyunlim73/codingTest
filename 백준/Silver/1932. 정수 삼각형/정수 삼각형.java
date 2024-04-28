import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] triangle;
    static ArrayList<Integer>[] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        triangle = new ArrayList[N];
        dp = new ArrayList[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            triangle[i] = new ArrayList<>();
            dp[i] = new ArrayList<>();
            for(int j = 0; j < i + 1; j++){
                triangle[i].add(Integer.parseInt(st.nextToken()));
                dp[i].add(null);
            }
        }

        for(int i = 0; i < N; i++){
            dp[N-1].set(i, triangle[N-1].get(i));
        }

        System.out.println(find(0, 0));
        
        br.close();
    }

    static int find(int depth, int idx){
        if(depth == N-1)
            return dp[N-1].get(idx);
        if(dp[depth].get(idx) == null){
            dp[depth].set(idx, Math.max(find(depth+1, idx), find(depth+1, idx+1)) + triangle[depth].get(idx));
        }
        return dp[depth].get(idx);
    }
}