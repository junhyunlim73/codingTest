import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[][] visited;
    static int[][] danji;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        danji = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] temp = br.readLine().split("");
            for(int j = 0; j < n; j++){
                danji[i][j] = Integer.parseInt(temp[j]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && danji[i][j] == 1)
                    list.add(BFS(i, j));
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int i : list){
            System.out.println(i);
        }
        br.close();
    }
    private static int BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        int cnt = 1;
        visited[i][j] = true;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k = 0; k < 4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >=0 && x < n && y < n){
                    if(!visited[x][y] && danji[x][y] == 1){
                        queue.add(new int[] {x, y});
                        visited[x][y] =true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}