import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dr = {2, 1, -1, -2,-2,-1, 1, 2};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int l = Integer.parseInt(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            visited = new boolean[l][l];
            map = new int[l][l];
            int start[] = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            q.add(new int[]{start[0], start[1]});
            visited[start[0]][start[1]] = true;

            int end[] = new int[2];
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int c = cur[0];
                int r = cur[1];

                for(int k = 0; k < 8; k++) {
                    int nc = c+ dc[k];
                    int nr = r + dr[k];

                    if(nc >= 0 && nc < l && nr >= 0 && nr < l && !visited[nc][nr]) {
                        visited[nc][nr] = true;
                        map[nc][nr] = map[c][r] + 1;
                        q.add(new int[]{nc, nr});
                    }

                }

            }

            sb.append(map[end[0]][end[1]] + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}