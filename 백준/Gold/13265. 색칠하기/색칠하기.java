import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adj;
    static String color[];
    static String red = "red";
    static String blue = "blue";
    static int T;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adj = new ArrayList[n + 1];
            color = new String[n + 1];
            flag = false;

            for(int j = 0; j < n + 1; j++) {
                adj[j] = new ArrayList<>();
            }

            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adj[x].add(y);
                adj[y].add(x);
            }

            Arrays.fill(color, "");

            for(int j = 1; j < n+1; j++) {
                if(flag)
                    break;
                if(color[j].equals("")) {
                    color[j] = red;
                    dfs(j);

                }
            }

            sb.append(!flag ? "possible" : "impossible").append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int i){
        if(flag)
            return;

        for(int num : adj[i]) {
            if(color[num].equals("") && !flag) {
                color[num] = color[i].equals(red) ? blue : red;
                dfs(num);
            }
            if(color[num].equals(color[i])) {
                flag = true;
                return;
            }
        }
    }
}