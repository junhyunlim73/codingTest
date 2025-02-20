import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static ArrayDeque<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            visited = new boolean[N][M];

            q = new ArrayDeque<>();
            HashMap<Integer, int[]> list = new HashMap<>();
            int key = 0;
            int time = 0;

            for (int i = 0; i < N; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line[j];

                    if(map[i][j] == '@'){
                        q.addFirst(new int[]{i, j, 0, 0});
                    }else if(map[i][j] == '*'){
                        list.put(key, new int[]{i, j});
                        q.addLast(new int[]{i, j, 1});
                    }

                }
            }

            for(int idx : list.keySet()){
                int[] rc = list.get(idx);
                preFireArea(rc[0], rc[1]);
            }

            time = bfs();

            sb.append(time != -1 ? time : "IMPOSSIBLE").append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static void preFireArea(int r, int c){
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                continue;

            if(map[nr][nc] == '.')
                map[nr][nc] = '^';
        }
    }

    private static int bfs(){
        while(!q.isEmpty()){
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int s = now[2];

            if(s == 0){
                for(int i = 0; i < 4; i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                        return (now[3] + 1);
                    }

                    if(visited[nr][nc])
                        continue;

                    if(map[nr][nc] == '.'){
                        visited[nr][nc] = true;
                        map[nr][nc] = '@';
                        q.add(new int[]{nr, nc, 0, now[3] + 1});
                    }
                }

                map[r][c] = '.';
            }else{
                for(int i = 0; i < 4; i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                        continue;

                    if(visited[nr][nc])
                        continue;

                    if(map[nr][nc] == '.' || map[nr][nc] == '^'){
                        visited[nr][nc] = true;
                        map[nr][nc] = '*';
                        q.add(new int[]{nr, nc, 1});
                        preFireArea(nr, nc);
                    }

                }
            }

        }

        return -1;
    }

}