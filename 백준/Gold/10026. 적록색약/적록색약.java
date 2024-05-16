import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] visited;
    static char[][] area;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        area = new char[N][N];
        int normal = 0;
        int adnormal = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                area[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    normal++;
                    dfs(i, j, area[i][j]);
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(area[i][j] == 'G') {
                    area[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    adnormal++;
                    dfs(i, j, area[i][j]);
                }
            }
        }

        System.out.println(normal + " " + adnormal);
        br.close();
    }

    static void dfs(int r, int c, char color) {
        visited[r][c] = true;

        for(int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) {
                continue;
            }
            if(color == area[nr][nc]) {
                dfs(nr, nc, color);
            }
        }

    }
}