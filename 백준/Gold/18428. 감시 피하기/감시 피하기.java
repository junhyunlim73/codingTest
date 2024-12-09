import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static String[][] board;
    static int N;
    static ArrayList<int[]> X;
    static ArrayList<int[]> T;
    static boolean isPos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        board = new String[N][N];
        X = new ArrayList<>();
        T = new ArrayList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = st.nextToken();

                if(board[i][j].equals("X")){
                    X.add(new int[]{i, j});
                }else if(board[i][j].equals("T")){
                    T.add(new int[]{i, j});
                }

            }
        }

        combi(0, 0);
        System.out.println(isPos ? "YES" : "NO");
        br.close();
    }

    private static void combi(int index, int depth) {
        if(depth == 3){
            boolean flag = false;

            for(int[] now : T){
                int row = now[0];
                int col = now[1];

                for(int i = 0; i < 4; i++){
                    int nr = row + dr[i];
                    int nc = col + dc[i];

                    while(!flag && nr >= 0 && nr < N && nc >= 0 && nc < N){
                        if(board[nr][nc].equals("O")){
                            break;
                        }else if(board[nr][nc].equals("S")){
                            flag = true;
                            break;
                        }else{
                            nr += dr[i];
                            nc += dc[i];
                        }
                    }

                }

                if(flag)
                    break;
            }

            isPos = !flag ? true : false;

            return;
        }

        if(index == X.size()){
            return;
        }

        for(int i = index; i < X.size(); i++){
            int[] arr = X.get(i);
            int row = arr[0];
            int col = arr[1];

            if(!isPos && !visited[row][col]){
                visited[row][col] = true;
                board[row][col] = "O";
                combi(i+1, depth + 1);
                visited[row][col] = false;
                board[row][col] = "X";
            }

        }
    }
}