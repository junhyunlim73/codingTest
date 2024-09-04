import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parents;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] board;
    static boolean[][] visited;
    static int cnt;
    static long mst;
    static boolean[][][] connect;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        board = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        parents = new int[cnt + 1];
        connect = new boolean[cnt+1][cnt+1][10];
        for(int i = 1; i < cnt + 1; i++){
            parents[i] = i;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] != 0){
                    rightCheck(i , j);
                    leftCheck(i, j);
                    upCheck(i, j);
                    downCheck(i , j);
                }
            }
        }

        int b = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int start = find(node.start);
            int end = find(node.end);

            if(start != end){
                union(start, end);
                mst += node.weight;
                b++;
            }

            if(b == cnt - 1)
                break;
        }
        
        System.out.println(mst != 0 && b == cnt - 1 ? mst : -1);
        br.close();
    }

    private static void bfs(int i, int j){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        board[i][j] = cnt;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];

            for(int k = 0; k < 4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if(board[nr][nc] == 1 && ! visited[nr][nc]){
                    visited[nr][nc] = true;
                    board[nr][nc] = cnt;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    private static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x < y)
            parents[y] = x;
        else
            parents[x] = y;
    }

    private static void rightCheck(int i, int j){
        int start = board[i][j];
        int weight = 0;

        for(int k = j + 1; k < M; k++){
            if(board[i][k] == 0){
                weight++;
            }else if(board[i][k] == start){
                return;
            }else{
                int end = board[i][k];

                if(weight >= 2){
                    if(!connect[start][end][weight] && !connect[end][start][weight]){
                        pq.add(new Node(start, end, weight));
                        connect[start][end][weight] = true;
                        connect[end][start][weight] = true;
                    }
                }

                return;
            }
        }

    }

    private static void leftCheck(int i, int j){
        int start = board[i][j];
        int weight = 0;

        for(int k = j - 1; k >= 0; k--){
            if(board[i][k] == 0){
                weight++;
            }else if(board[i][k] == start){
                return;
            }else{
                int end = board[i][k];

                if(weight >= 2){
                    if(!connect[start][end][weight] && !connect[end][start][weight]){
                        pq.add(new Node(start, end, weight));
                        connect[start][end][weight] = true;
                        connect[end][start][weight] = true;
                    }
                }

                return;
            }
        }
    }

    private static void upCheck(int i, int j){
        int start = board[i][j];
        int weight = 0;

        for(int k = i - 1; k >= 0; k--){
            if(board[k][j] == 0){
                weight++;
            }else if(board[k][j] == start){
                return;
            }else{
                int end = board[k][j];

                if(weight >= 2){
                    if(!connect[start][end][weight] && !connect[end][start][weight]){
                        pq.add(new Node(start, end, weight));
                        connect[start][end][weight] = true;
                        connect[end][start][weight] = true;
                    }
                }

                return;
            }
        }
    }

    private static void downCheck(int i, int j){
        int start = board[i][j];
        int weight = 0;

        for(int k = i + 1; k < N; k++){
            if(board[k][j] == 0){
                weight++;
            }else if(board[k][j] == start){
                return;
            }else{
                int end = board[k][j];

                if(weight >= 2){
                    if(!connect[start][end][weight] && !connect[end][start][weight]){
                        pq.add(new Node(start, end, weight));
                        connect[start][end][weight] = true;
                        connect[end][start][weight] = true;
                    }
                }

                return;
            }
        }
    }

    static class Node implements Comparable<Node> {
        int start, end, weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

}