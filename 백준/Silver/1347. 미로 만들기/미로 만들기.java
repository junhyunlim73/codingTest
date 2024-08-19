import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {
    static char[][]  board;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        int n = Integer.parseInt(br.readLine());
        String[] commend = br.readLine().split("");
        int r = 0;
        int c = 0;
        int min_r = 0;
        int min_c = 0;
        int max_r = 0;
        int max_c = 0;

        LinkedHashSet<String> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            if(commend[i].equals("F")){
                r += dr[idx];
                c += dc[idx];

                set.add(r + " " + c);
                min_r = Math.min(min_r, r);
                min_c = Math.min(min_c, c);
                max_c = Math.max(max_c, c);
                max_r = Math.max(max_r, r);
            }else if(commend[i].equals("R")){
                idx = (idx + 1) % 4;
            }else if(commend[i].equals("L")){
                idx = (idx + 3) % 4;
            }
        }

        int row = max_r - min_r + 1;
        int col = max_c - min_c + 1;

        board = new char[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                board[i][j] = '#';
            }
        }

        int diff = min_r * (-1);
        int diff2 = min_c * (-1);

        for(String num : set){
            String[] temp = num.split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            int nr =  x + diff;
            int nc = y + diff2;
            board[nr][nc] = '.';
        }

        board[diff][diff2] = '.';

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
               sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}