import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int fish;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static PriorityQueue<Shark> pq;
    static int sharkR, sharkC, time, size, eat;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        ArrayDeque<Shark> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 9){
                    sharkR = i;
                    sharkC = j;
                    board[i][j] = 0;
                }else if(board[i][j] != 0){
                    fish++;
                }

            }
        }

        if(fish == 0){
            System.out.println(0);
            return;
        }

        size = 2;
        pq = new PriorityQueue<>();

        while(!flag){
            visited = new boolean[N][N];
            pq.add(new Shark(sharkR, sharkC, 0));
            visited[sharkR][sharkC] = true;
            flag = true;

            bfs(pq);
        }

        System.out.println(time);
        br.close();
    }

    private static void bfs(PriorityQueue<Shark> pq){
        while(!pq.isEmpty()){
            Shark shark = pq.poll();
            int r = shark.r, c = shark.c;

            if(board[r][c] > 0 && board[r][c] < size){
                time += shark.dist;

                if(++eat == size){
                    eat = 0;
                    size++;
                }

                sharkR = r;
                sharkC = c;
                board[r][c] = 0;
                flag = false;
                pq.clear();
                break;
            }

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;

                if(!visited[nr][nc] && board[nr][nc] <= size){
                    visited[nr][nc] = true;
                    pq.add(new Shark(nr, nc, shark.dist + 1));
                }

            }
        }
    }

    static class Shark implements Comparable<Shark>{
        int r, c, dist;

        public Shark(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        public int compareTo(Shark o){
            if(this.dist != o.dist){
                return Integer.compare(this.dist, o.dist);
            }else{
                if(this.r != o.r){
                    return Integer.compare(this.r, o.r);
                }else
                    return Integer.compare(this.c, o.c);
            }
        }

    }

}