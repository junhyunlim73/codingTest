import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int[][] board;
    static boolean[][] r_visited;
    static boolean[][] c_visited;
    static boolean[][] s_visited;
    static ArrayList<int[]> rc = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        r_visited = new boolean[9][10];
        c_visited = new boolean[9][10];
        s_visited = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(arr[j]);

                if(board[i][j] != 0){
                    int s = squre(i, j);
                    r_visited[i][board[i][j]] = true;
                    c_visited[j][board[i][j]] = true;
                    s_visited[s][board[i][j]] = true;
                }else{
                    rc.add(new int[]{i, j});
                }
            }
        }

        perm(0);
        print();
        br.close();
    }

    private static int squre(int r, int c) {
        return (r / 3) * 3 + c / 3;
    }

    private static void perm(int depth){
        if(depth == rc.size()){
            flag = true;
            return;
        }

        for(int i = 1; i < 10; i++){
            if(flag)
                return;

            int[] now = rc.get(depth);
            int r = now[0];
            int c = now[1];
            int s = squre(r, c);

            if(!r_visited[r][i] && !c_visited[c][i] && !s_visited[s][i]){
                r_visited[r][i] = true;
                c_visited[c][i] = true;
                s_visited[s][i] = true;
                board[r][c] = i;
                perm(depth+1);
                r_visited[r][i] = false;
                c_visited[c][i] = false;
                s_visited[s][i] = false;
            }
        }
    }

    private static void print(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}