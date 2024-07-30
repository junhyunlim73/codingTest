import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static int max;
    static int cnt;
    static Queue<int[]> queue;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        list = new ArrayList<>();
        board = new int[N][M];
        cnt = N * M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 2){
                    queue.add(new int[]{i, j});
                    cnt--;
                }else if(board[i][j] == 1){
                    cnt--;
                }else if(board[i][j] == 0){
                    list.add(new int[]{i, j});
                }
            }
        }

        combi(0, 0);
        System.out.println(max);

    }

    private static void combi(int depth, int index){
        if(depth == 3){
            dfs(queue);
            return;
        }

        for(int i = index; i < list.size(); i++){
            int[] temp = list.get(i);
            int r = temp[0];
            int c = temp[1];

            board[r][c] = 1;
            cnt--;
            combi(depth+1, i + 1);
            board[r][c] = 0;
            cnt++;
        }

    }

    private static void dfs(Queue<int[]> queue){
        Queue<int[]> q = new LinkedList<>(queue);
        boolean flag = false;
        visited = new boolean[N][M];
        int area = cnt;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || board[nr][nc] != 0)
                    continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
                area--;
            }

            if(max != 0 && area <= max){
                flag = true;
                break;
            }

        }

        if(!flag){
            max = Math.max(max, area);
        }

    }
}