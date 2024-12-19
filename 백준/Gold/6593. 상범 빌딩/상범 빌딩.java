import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static char[][][] board;
    static boolean[][][] visited;
    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dc = {-1, 1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int L, R, C;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            boolean flag = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0){
                break;
            }

            board = new char[L][R][C];
            visited = new boolean[L][R][C];

            int start_r = 0, start_c = 0, start_h = 0;
            int end_r = 0, end_c = 0, end_h = 0;

            for (int i = 0; i < L; i++){
                for (int j = 0; j < R; j++){
                    char[] line = br.readLine().toCharArray();
                    for (int k = 0; k < C; k++){
                        board[i][j][k] = line[k];

                        if(board[i][j][k] == 'S'){
                            start_h = i;
                            start_r = j;
                            start_c = k;
                        }else if(board[i][j][k] == 'E'){
                            end_h = i;
                            end_r = j;
                            end_c = k;
                        }

                    }
                }
                br.readLine();
            }

            ArrayDeque<People> q = new ArrayDeque<>();
            q.add(new People(start_h, start_r, start_c, 0));
            visited[start_h][start_r][start_c] = true;

            while (!q.isEmpty()){
                People p = q.poll();
                int r = p.r;
                int c = p.c;
                int h = p.h;
                int time = p.time;

                if(h == end_h && r == end_r && c == end_c){
                    result = time;
                    flag = true;
                    break;
                }

                for (int i = 0; i < 6; i++){
                    int nh = h + dh[i];
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(nh < 0 || nr < 0 || nc < 0 || nh >= L || nr >= R || nc >= C){
                        continue;
                    }

                    if(visited[nh][nr][nc]){
                        continue;
                    }

                    if(board[nh][nr][nc] != '#'){
                        q.add(new People(nh, nr, nc, time+1));
                        visited[nh][nr][nc] = true;
                    }

                }

            }

            if(flag){
                sb.append("Escaped in " + result +" minute(s).").append("\n");
            }else{
                sb.append("Trapped!\n");
            }

        }

        System.out.print(sb);
        br.close();
    }

    static class People{
        int h, r, c, time;

        public People(int h, int r, int c, int time){
            this.h = h;
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

}