import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<int[]> list = new ArrayList<>();
    static boolean[][] visited;
    static int[][] board;
    static boolean[] isCheck;
    static int N, M;
    static int cnt;
    static int[][] sel;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int time = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 0){
                    cnt++;
                }else if(board[i][j] == 2){
                    list.add(new int[]{i, j});
                }

            }
        }

        sel = new int[M][2];
        isCheck = new boolean[list.size()];

        if(cnt == 0){
            System.out.println(0);
        }else{
            combi(0, 0);
            System.out.println(time != Integer.MAX_VALUE ? time : -1);
        }

        br.close();
    }

    private static void combi(int depth, int index){
        if(depth == M){
            int total = dfs();

            if(total != -1){
                time = Math.min(time, total);
            }

            return;
        }

        if(index == list.size()){
            return;
        }

        for(int i = index; i < list.size(); i++){
            if(!isCheck[i]){
                int[] arr = list.get(i);
                sel[depth][0] = arr[0];
                sel[depth][1] = arr[1];
                isCheck[i] = true;
                combi(depth + 1, i + 1);
                isCheck[i] = false;
            }
        }

    }

    private static int dfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int time = 0;
        int num = 0;

        visited = new boolean[N][N];

        for(int[] arr : sel){
            q.add(new int[]{arr[0], arr[1], 0});
            visited[arr[0]][arr[1]] = true;
        }

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i = 0; i < 4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N)
                    continue;

                if(!visited[nr][nc] && board[nr][nc] == 0){
                    q.add(new int[]{nr, nc, now[2]+1});
                    time = Math.max(time, now[2]+1);
                    visited[nr][nc] = true;
                    num++;
                }else if(!visited[nr][nc] && board[nr][nc] == 2){
                    q.add(new int[]{nr, nc, now[2]+1});
                    visited[nr][nc] = true;
                }

            }

        }

        if(num == cnt)
            return time;
        else
            return -1;
    }

}