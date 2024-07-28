import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<int[]> o;
    static ArrayList<int[]> t;
    static boolean[][] visited;
    static String[][] board;
    static int N;
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        o = new ArrayList<>();
        t = new ArrayList<>();
        visited = new boolean[N][N];
        board = new String[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = st.nextToken();

                if(board[i][j].equals("X"))
                    o.add(new int[]{i, j});
                else if(board[i][j].equals("T"))
                    t.add(new int[]{i, j});

            }
        }

        perm(0);

        System.out.println(isPossible ? "YES" : "NO");
    }

    private static void perm(int depth){
        if(depth == 3){
            boolean flag = false;

            for(int i = 0; i < t.size(); i++){
                int[] cur = t.get(i);
                int r = cur[0];
                int c = cur[1];

                for(int j = 0; j < 4; j++){
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    while (nr >= 0 && nr < N && nc >= 0 && nc < N){
                        if(board[nr][nc].equals("O"))
                            break;
                        else if(board[nr][nc].equals("S")){
                            flag = true;
                            break;
                        }else{
                            nr = nr + dr[j];
                            nc = nc + dc[j];
                        }

                    }

                    if(flag)
                        break;
                }

                isPossible = !flag ? true : false;
            }

            return;
        }

        for(int i = 0; i < o.size(); i++){
            int[] cur = o.get(i);
            if(!visited[cur[0]][cur[1]] && !isPossible){
                visited[cur[0]][cur[1]] = true;
                board[cur[0]][cur[1]] = "O";
                perm(depth+1);
                board[cur[0]][cur[1]] = "X";
                visited[cur[0]][cur[1]] = false;
            }
        }

    }
}