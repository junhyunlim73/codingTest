import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] r_visited;
    static boolean[][] c_visited;
    static boolean[][] s_visited;
    static ArrayList<int[]> list;
    static boolean flag;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        r_visited = new boolean[9][10];
        c_visited = new boolean[9][10];
        s_visited = new boolean[9][10];
        list = new ArrayList<>();

        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                int num = Integer.parseInt(st.nextToken());

                if(num == 0){
                    list.add(new int[]{i,j});
                }else{
                    r_visited[i][num] = true;
                    c_visited[j][num] = true;
                    int s = boxNum(i, j);
                    s_visited[s][num] = true;
                    board[i][j] = num;
                }
            }
        }

        perm(0);
        System.out.print(sb.toString());
        br.close();
    }

    private static void perm(int depth){
        if(depth == list.size()){
            flag = true;
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        for(int k = 1 ; k < 10; k++){
            if(!flag){
                int[] now = list.get(depth);
                int r = now[0];
                int c = now[1];
                int s = boxNum(r, c);

                if(!r_visited[r][k] && !c_visited[c][k] && !s_visited[s][k]){
                    board[r][c] = k;
                    r_visited[r][k] = true;
                    c_visited[c][k] = true;
                    s_visited[s][k] = true;
                    perm(depth + 1);
                    r_visited[r][k] = false;
                    c_visited[c][k] = false;
                    s_visited[s][k] = false;
                }

            }
        }

    }

    private static int boxNum(int i , int j){
        if(i >= 0 && i < 3 &&  j >= 0 && j < 3){
            return 0;
        }else if(i >= 0 && i < 3 &&  j >= 3 && j < 6){
            return 1;
        }else if(i >= 0 && i < 3 &&  j >= 6 && j < 9){
            return 2;
        }else if(i >= 3 && i < 6 && j >= 0 && j < 3){
            return 3;
        }else if(i >= 3 && i < 6 &&  j >= 3 && j < 6){
            return 4;
        }else if(i >= 3 && i < 6 &&  j >= 6 && j < 9){
            return 5;
        }else if(i >= 6 && i < 9 && j >= 0 && j < 3){
            return 6;
        }else if(i >= 6 && i < 9 && j >= 3 && j < 6){
            return 7;
        }else{
            return 8;
        }
    }

}