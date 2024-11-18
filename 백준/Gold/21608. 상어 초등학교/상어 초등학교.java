import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static LinkedHashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
    static int[] nums = {0, 1, 10, 100, 1000};
    static int[][] board;
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        int p = N*N;

        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            map.put(key, new ArrayList<>());

            for (int j = 0; j < 4; j++) {
                map.get(key).add(Integer.parseInt(st.nextToken()));
            }

        }

        for(int key : map.keySet()) {
            ArrayList<Integer> list = map.get(key);
            int[] arr = getRc(list);
            board[arr[0]][arr[1]] = key;
        }

        long sum = hap();
        System.out.println(sum);
        br.close();
    }

    private static int[] getRc(ArrayList<Integer> list){
        int[] res = new int[2];
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 0) {
                    Edge edge = getEdge(i, j, list);
                    edges.add(edge);
                }
            }
        }

        Collections.sort(edges);

        if(!edges.isEmpty()){
            Edge edge = edges.get(0);
            res[0] = edge.r;
            res[1] = edge.c;
        }

        return res;
    }

    private static Edge getEdge(int r, int c, ArrayList<Integer> list){
        int max = 0;
        int friends = 0;

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                continue;

            if(board[nr][nc] == 0)
                max++;
            else if(list.contains(board[nr][nc]))
                friends++;
        }

        return new Edge(r, c, max, friends);
    }

    private static long hap(){
        long sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int idx = getIdx(i, j);
                sum += nums[idx];
            }
        }

        return sum;
    }

    private static int getIdx(int r, int c){
        int key = board[r][c];
        ArrayList<Integer> list = map.get(key);
        int cnt = 0;

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                continue;

            if(list.contains(board[nr][nc]))
                cnt++;
        }

        return cnt;
    }
    static class Edge implements Comparable<Edge>{
        int r, c, max, friends;

        public Edge(int r, int c, int max, int friends) {
            this.r = r;
            this.c = c;
            this.max = max;
            this.friends = friends;
        }

        public int compareTo(Edge o) {
            if(this.friends == o.friends){
                if(this.max == o.max){

                    if(this.r == o.r){
                        return Integer.compare(this.c, o.c);
                    }

                    return Integer.compare(this.r, o.r);
                }

                return Integer.compare(o.max, this.max);
            }

            return Integer.compare(o.friends, this.friends);
        }

    }

}