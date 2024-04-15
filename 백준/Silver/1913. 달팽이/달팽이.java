import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] snail;
    static int N, target;
    static int targetR = 0, targetY = 0;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        snail = new int[N][N];
        int r = 0;
        int c = 0;
        int d = 0;
        for(int i = N * N; i > 0; i--){
            snail[r][c] = i;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= N || nc >= N  || snail[nr][nc] != 0){
                d = (d+1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }
            r = nr;
            c = nc;
        }
        print(snail);
        br.close();
    }

    static void print(int[][] graph){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                if(target == graph[i][j]){
                    targetR = i + 1;
                    targetY = j + 1;
                }
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.out.println(targetR + " " + targetY);
    }
}