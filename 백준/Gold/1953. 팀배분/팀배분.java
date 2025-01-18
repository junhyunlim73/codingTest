import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer> blue;
    static ArrayList<Integer> white;
    static int[] colors;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        colors = new int[N+1];
        blue = new ArrayList<>();
        white = new ArrayList<>();

        for(int i = 1; i < N+1; i++){
            adj[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            for(int j = 0; j < a; j++){
                adj[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 1; i < N+1; i++){
            if(colors[i] != 0)
                continue;

            bfs(i);
        }

        Collections.sort(blue);
        Collections.sort(white);

        sb.append(blue.size()).append("\n");

        for(int n : blue){
            sb.append(n).append(" ");
        }

        sb.append("\n").append(white.size()).append("\n");

        for(int n : white){
            sb.append(n).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int start){
        if(colors[start] == 0){
            colors[start] = 1;
            blue.add(start);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int n : adj[cur]){
                if(colors[n] == 0){
                    colors[n] = 3 - colors[cur];

                    if(colors[n] == 1){
                        blue.add(n);
                    }else{
                        white.add(n);
                    }

                    q.add(n);
                }
            }

        }

    }

}