import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] campus;
    static boolean[][] visited;
    static int N, M;
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] start = new int[2];
        int cnt = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();

            for(int j = 0; j < ch.length; j++) {
                campus[i][j] = ch[j];
                if(ch[j] == 'I'){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nc = cur[0] + dc[i];
                int nr = cur[1] + dr[i];

                if(nc < 0 || nc >= N || nr < 0 || nr >= M || visited[nc][nr] || campus[nc][nr] == 'X')
                    continue;

                if(campus[nc][nr] == 'P'){
                    queue.add(new int[]{nc, nr});
                    cnt++;
                    visited[nc][nr] = true;
                }else if(campus[nc][nr] == 'O'){
                    queue.add(new int[]{nc, nr});
                    visited[nc][nr] = true;
                }
            }
        }

        System.out.println(cnt != 0 ? cnt : "TT");
        br.close();
    }
}