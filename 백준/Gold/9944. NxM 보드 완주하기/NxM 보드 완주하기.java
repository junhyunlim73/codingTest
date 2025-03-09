import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Main {
    static boolean[][] visited;
    static char[][] board;
    static int N, M;
    static int min;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int ca = 1;

        while(true){
            String input = br.readLine();

            if(input == null || input.isEmpty())
                break;

            String[] tokens = input.split(" ");
            N = Integer.parseInt(tokens[0]);
            M = Integer.parseInt(tokens[1]);
            visited = new boolean[N][M];
            board = new char[N][M];
            min = 1_000_001;
            HashSet<int[]> set = new HashSet<>();

            for(int i = 0; i < N; i++){
                char[] arr = br.readLine().toCharArray();
                for(int j = 0; j < M; j++){
                    board[i][j] = arr[j];

                    if(board[i][j] == '.'){
                        set.add(new int[]{i, j});
                    }

                }
            }

            int cnt = set.size();

            for(int[] arr : set){
                int r = arr[0];
                int c = arr[1];
                visited[r][c] = true;
                cnt--;
                perm(r, c, 0, cnt);
                cnt++;
                visited[r][c] = false;
            }

            sb.append("Case ").append(ca).append(": ").append(min != 1_000_001 ? min : -1).append("\n");
            ca++;
        }

        System.out.print(sb);
        br.close();
    }

    private static void perm(int r, int c, int level, int total){
        if(total == 0){
            min = Math.min(min, level);
            return;
        }

        if(min <= level)
            return;

        for(int i = 0; i < 4; i++){
            LinkedHashMap<Integer, int[]> map = move(r, c, i);

            if (map.isEmpty())
                continue;

            int key = map.size();
            int[] arr = map.get(key);
            int nr = arr[0];
            int nc = arr[1];
            perm(nr, nc, level + 1, total - key);

            for(int k : map.keySet()){
                int[] rc = map.get(k);
                visited[rc[0]][rc[1]] = false;
            }

        }

    }

    private static LinkedHashMap<Integer, int[]> move(int r, int c, int d){
        LinkedHashMap<Integer, int[]> map = new LinkedHashMap<>();
        int key = 1;

        while(true){
            r += dr[d];
            c += dc[d];

            if(r < 0 || r >= N || c < 0 || c >= M)
                break;

            if(visited[r][c] || board[r][c] == '*')
                break;

            if(board[r][c] == '.'){
                map.put(key++, new int[]{r, c});
                visited[r][c] = true;
            }

        }

        return map;
    }

}