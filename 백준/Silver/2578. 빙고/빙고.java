import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] check;
    static int[][] calls;
    static int bingo, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[5][5];
        check = new boolean[5][5];
        calls = new int[5][5];
        HashMap<Integer, int[]> map = new HashMap<>();
        StringTokenizer st;

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                map.put(board[i][j], new int[]{i, j});
            }
        }

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                calls[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                cnt++;
                int r = map.get(calls[i][j])[0];
                int c = map.get(calls[i][j])[1];
                check[r][c] = true;

                if(horizontalCheck(r, c)){
                    bingo++;
                }

                if(verticalCheck(r, c)){
                    bingo++;
                }

                if(r == c && rightLine(r, c)){
                    bingo++;
                }

                if((r + c == 4) && leftLine(r, c)){
                    bingo++;
                }

                if(bingo >= 3){
                    break;
                }
            }

            if(bingo >= 3)
                break;
        }

        System.out.println(cnt);
        br.close();
    }

    private static boolean horizontalCheck(int r, int c){
        for(int i = 0; i < c + 1; i++){
            if(!check[r][i])
                return false;
        }

        for(int i = c + 1; i < 5; i++){
            if(!check[r][i])
                return false;
        }

        return true;
    }

    private static boolean verticalCheck(int r, int c){
        for(int i = 0; i < r + 1; i++){
            if(!check[i][c])
                return false;
        }

        for(int i = r + 1; i < 5; i++){
            if(!check[i][c])
                return false;
        }

        return true;
    }

    private static boolean rightLine(int r, int c){
        for(int i = 0; i < r + 1; i++){
            if(!check[i][i]){
                return false;
            }
        }

        for(int i = r + 1; i < 5; i++){
            if(!check[i][i])
                return false;
        }

        return true;
    }

    private static boolean leftLine(int r, int c){
        for(int i = 0; i < r + 1; i++){
            if(!check[i][4 - i]){
                return false;
            }
        }

        for(int i = r + 1; i < 5; i++){
            if(!check[i][4 - i])
                return false;
        }

        return true;
    }

}