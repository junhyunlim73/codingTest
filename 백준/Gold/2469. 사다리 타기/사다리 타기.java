import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int k, n;
    static int[][] board;
    static int[] target, nows;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        board = new int[n][k];
        target = new int[k];
        nows = new int[k];

        char[] chars = br.readLine().toCharArray();

        for (int i = 0; i < k; i++) {
            target[i] = chars[i] - 'A';
        }

        for(int i = 0; i < n; i++){
            char[] chars2 = br.readLine().toCharArray();

            for(int j = 0; j < k-1; j++){
                if(chars2[j] == '?'){
                    idx = i;
                    break;
                }else{
                    board[i][j] = chars2[j] == '-' ? 1 : 0;
                }
            }

        }

        for(int i = 0; i < k; i++){
            nows[i] = preMove(i);
        }

        for(int i = 0; i < 1 << (k-1); i++){
            boolean flag = false;

            for(int j = 0; j < (k-1); j++){
                if((i & (1 << j)) != 0){
                    if(j != 0 && board[idx][j-1] == 1){
                        flag = true;
                        break;
                    }
                    board[idx][j] = 1;
                }else{
                    board[idx][j] = 0;
                }

            }

            if(flag)
                continue;

            if(isCheck()){
                for(int j = 0; j < (k-1); j++){
                    sb.append(board[idx][j] == 1 ? "-" : "*");
                }
                System.out.println(sb);
                return;
            }

        }

        System.out.println("x".repeat(k-1));
        br.close();
    }

    private static boolean isCheck(){
        for(int i = 0; i < k; i++){
            if(!move(nows[i], i))
                return false;
        }

        return true;
    }

    private static int preMove(int start){
        for(int i = 0; i < idx; i++){
            if(start == 0){
                if(board[i][start] == 1){
                    start++;
                }
            }else if(start == k - 1){
                if(board[i][start-1] == 1){
                    start--;
                }
            }else{
                if(board[i][start] == 1){
                    start++;
                }else if(board[i][start-1] == 1){
                    start--;
                }
            }
        }

        return start;
    }

    private static boolean move(int start, int t){
        for(int i = idx; i < n; i++){
            if(start == 0){
                if(board[i][start] == 1){
                    start++;
                }
            }else if(start == k - 1){
                if(board[i][start-1] == 1){
                    start--;
                }
            }else{
                if(board[i][start] == 1){
                    start++;
                }else if(board[i][start-1] == 1){
                    start--;
                }
            }
        }

        return target[start] == t;
    }

}