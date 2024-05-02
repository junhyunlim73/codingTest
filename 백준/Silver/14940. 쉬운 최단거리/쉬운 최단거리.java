import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] visited;
    static int n, m;
    static int[] dc = {-1,1,0,0};
    static int[] dr = {0,0,-1,1};
    static int r, c;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    c = i;
                    r = j;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.add(new int[] {c, r});
        map[c][r] = 0;

        while(!queue.isEmpty()){
            int[] now = queue.remove();
            visited[now[0]][now[1]] = 1;
            for(int i = 0; i < 4; i++){
                int nc = now[0] + dc[i];
                int nr = now[1] + dr[i];
                if(nc < 0 || nr < 0 || nc >= n || nr >= m || map[nc][nr] != 1 || visited[nc][nr] == 1)
                    continue;
                map[nc][nr] = map[now[0]][now[1]] + 1;
                queue.add(new int[] {nc, nr});
            }

        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1 && visited[i][j] == 0){
                    sb.append("-1 ");
                }else{
                    sb.append(map[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}