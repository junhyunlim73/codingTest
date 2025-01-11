import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board, temp;
    static HashMap<Integer, int[]> map = new HashMap<>();
    static int[] sel;
    static int cnt = 0;
    static int size = 0;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 0)
                    cnt++;
                else if(board[i][j] == 6)
                    continue;
                else
                    map.put(size++, new int[]{i, j, board[i][j]});
            }
        }

        sel = new int[size];
        min = cnt;

        if(cnt != 0)
            perm(0);

        System.out.println(min);
        br.close();
    }

    private static void perm(int depth){
        if(depth == size){
            temp = copyArray();
            int sum = 0;
            int total = 0;

            for(int i = 0; i < size; i++){
                int[] arr = map.get(i);

                if(arr[2] == 1){
                    sum += oneCamera(arr[0], arr[1], sel[i]);
                }else if(arr[2] == 2){
                    sum += twoCamera(arr[0], arr[1], sel[i]);
                }else if(arr[2] == 3){
                    sum += threeCamera(arr[0], arr[1], sel[i]);
                }else if(arr[2] == 4){
                    sum += fourCamera(arr[0], arr[1], sel[i]);
                }else if(arr[2] == 5){
                    sum += fiveCamera(arr[0], arr[1]);
                }
            }

            total = cnt - sum;
            min = Math.min(min, total);
            return;
        }

        int[] arr = map.get(depth);

        if(arr[2] != 2 && arr[2] != 5){
            for (int i = 0; i < 4; i++) {
                sel[depth] = i;
                perm(depth + 1);
            }
        } else if(arr[2] == 2){
            for (int i = 0; i < 2; i++) {
                sel[depth] = i;
                perm(depth + 1);
            }
        } else {
            for (int i = 0; i < 1; i++) {
                sel[depth] = i;
                perm(depth + 1);
            }
        }

    }

    private static int[][] copyArray(){
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = board[i][j];
            }
        }

        return temp;
    }

    private static int right(int i, int j){
        int cnt = 0;

        for(int k = j + 1; k < M; k++){
            if(temp[i][k] == 0){
                temp[i][k] = 7;
                cnt++;
            }else if(temp[i][k] == 6){
                break;
            }
        }

        return cnt;
    }

    private static int left(int i, int j){
        int cnt = 0;

        for(int k = j - 1; k >= 0; k--){
            if(temp[i][k] == 0){
                temp[i][k] = 7;
                cnt++;
            }else if(temp[i][k] == 6){
                break;
            }
        }

        return cnt;
    }

    private static int down(int i, int j){
        int cnt = 0;

        for(int k = i + 1; k < N; k++){
            if(temp[k][j] == 0){
                temp[k][j] = 7;
                cnt++;
            }else if(temp[k][j] == 6){
                break;
            }
        }

        return cnt;
    }

    private static int up(int i, int j){
        int cnt = 0;

        for(int k = i - 1; k >= 0; k--){
            if(temp[k][j] == 0){
                temp[k][j] = 7;
                cnt++;
            }else if(temp[k][j] == 6){
                break;
            }
        }

        return cnt;
    }

    private static int oneCamera(int i, int j, int id){
        int num = 0;

        if(id == 0){
            num += right(i, j);
        } else if (id == 1) {
            num += down(i, j);
        } else if (id == 2) {
            num += left(i, j);
        }else{
            num += up(i, j);
        }

        return num;
    }

    private static int twoCamera(int i, int j, int id){
        int num = 0;

        if(id == 0){
            num += right(i, j);
            num += left(i, j);
        } else{
            num += up(i, j);
            num += down(i, j);
        }

        return num;
    }

    private static int threeCamera(int i, int j, int id){
        int num = 0;

        if(id == 0){
            num += up(i, j);
            num += right(i, j);
        } else if (id == 1) {
            num += right(i, j);
            num += down(i, j);
        } else if (id == 2) {
            num += down(i, j);
            num += left(i, j);
        }else{
            num += left(i, j);
            num += up(i, j);
        }

        return num;
    }

    private static int fourCamera(int i, int j, int id){
        int num = 0;

        if(id == 0){
            num += left(i, j);
            num += up(i, j);
            num += right(i, j);
        } else if (id == 1) {
            num += up(i, j);
            num += right(i, j);
            num += down(i, j);
        } else if (id == 2) {
            num += right(i, j);
            num += down(i, j);
            num += left(i, j);
        }else{
            num += down(i, j);
            num += left(i, j);
            num += up(i, j);
        }

        return num;
    }

    private static int fiveCamera(int i, int j){
        int num = 0;

        num += up(i, j);
        num += right(i, j);
        num += down(i, j);
        num += left(i, j);

        return num;
    }

}