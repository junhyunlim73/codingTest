import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] inDegree;
    static ArrayList<Integer>[] adj;
    static int[] times, dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        times = new int[26];
        dp = new int[26];
        adj = new ArrayList[26];
        inDegree = new int[26];

        for (int i = 0; i < 26; i++) {
            adj[i] = new ArrayList<>();
        }

        while(true){
            String input = br.readLine();

            if(input == null || input.equals(""))
                break;

            StringTokenizer st = new StringTokenizer(input);
            int idx = st.nextToken().charAt(0) - 65;
            int time = Integer.parseInt(st.nextToken());
            times[idx] = time;

            if(st.hasMoreTokens()){
                char[] chars = st.nextToken().toCharArray();

                for(char c : chars){
                    int pre = c - 65;
                    adj[pre].add(idx);
                    inDegree[idx]++;
                }

            }

        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < 26; i++){
            if(inDegree[i] == 0 && times[i] != 0){
                queue.add(i);
                dp[i] = times[i];
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int d : adj[cur]){
                if(--inDegree[d] == 0){
                    queue.add(d);
                }
                dp[d] = Math.max(dp[d], dp[cur] + times[d]);
            }

        }

        for(int i = 0; i < 26; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        br.close();
    }

}