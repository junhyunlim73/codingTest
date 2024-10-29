import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[][] areaId;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int areaNum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        areaId = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String[] nums = br.readLine().split("");
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(nums[j]);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 0 && !visited[i][j]){
                    bfs(i, j);
                    areaNum++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 1){
                    bw.write(String.valueOf(getValue(i, j)));
                }else{
                    bw.write("0");
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int i, int j){
        int area = 1;
        visited[i][j] = true;
        areaId[i][j] = areaNum;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int k = 0; k < 4; k++){
                int nr = now[0] + dr[k];
                int nc = now[1] + dc[k];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;

                if(!visited[nr][nc] && board[nr][nc] == 0){
                    visited[nr][nc] = true;
                    areaId[nr][nc] = areaNum;
                    q.add(new int[]{nr, nc});
                    area++;
                }
            }

        }

        map.put(areaNum, area);
    }

    private static int getValue(int i, int j){
        int crash = 1;
        HashSet<Integer> set = new HashSet<>();

        for(int k = 0; k < 4; k++){
            int nr = i + dr[k];
            int nc = j + dc[k];

            if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                continue;

            int id = areaId[nr][nc];

            if(id != 0 && !set.contains(id)){
                crash += map.get(id);
                set.add(id);
            }

        }

        return (crash % 10);
    }

}