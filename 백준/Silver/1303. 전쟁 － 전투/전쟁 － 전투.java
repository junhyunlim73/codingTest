import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] area;
    static boolean[][] visited;
    static int N, M;
    static int w_atk, b_atk;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new char[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            area[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    int cnt = 1;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();

                        for(int k = 0; k < 4; k++){
                            int nr = cur[0] + dr[k];
                            int nc = cur[1] + dc[k];

                            if(nr < 0 || nc < 0 || nr >= M || nc >= N || visited[nr][nc] || area[i][j] != area[nr][nc]) continue;

                            q.add(new int[]{nr, nc});
                            visited[nr][nc] = true;
                            cnt++;
                        }
                    }

                    if(area[i][j] == 'W')
                        w_atk += Math.pow(cnt, 2);
                    else
                        b_atk += Math.pow(cnt, 2);
                }
            }
        }

        System.out.println(w_atk + " " + b_atk);

    }
}