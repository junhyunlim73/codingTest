import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static HashMap<Integer, int[]> map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        map = new HashMap<>();
        int key = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 1){
                    map.put(key++, new int[]{i, j});
                }
            }
        }

        dfs(0, 0);

        while (!map.isEmpty()) {
            time++;

            ArrayList<Integer> temp = new ArrayList<>();

            for(int k : map.keySet()) {
                int[] arr = map.get(k);
                int cnt = cntOut(arr[0], arr[1]);

                if(cnt >= 2){
                    temp.add(k);
                }

            }

            for(int k : temp) {
                int[] arr = map.get(k);
                dfs(arr[0], arr[1]);
                map.remove(k);
            }

        }

        System.out.println(time);
        br.close();
    }

    private static int cntOut(int i,  int j){
        int cnt = 0;

        for(int k = 0; k < 4; k++){
            int nr = i + dr[k];
            int nc = j + dc[k];

            if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                continue;

            if(board[nr][nc] == 2){
                cnt++;
            }
        }

        return cnt;
    }

    private static void dfs(int i, int j){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        board[i][j] = 2;
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int k = 0; k < 4; k++){
                int nr = cur[0] + dr[k], nc = cur[1] + dc[k];

                if(nr < 0 || nr >= N | nc < 0 || nc >= M)
                    continue;

                if(visited[nr][nc])
                    continue;

                if(board[nr][nc] == 0){
                    visited[nr][nc] = true;
                    board[nr][nc] = 2;
                    q.add(new int[]{nr, nc});
                }

            }

        }
    }

}