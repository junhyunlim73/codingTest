import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int N;
    static long mst;
    static int cnt;
    static PriorityQueue<Node> pq = new PriorityQueue<Node>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                int cost = Integer.parseInt(st.nextToken());

                if (j <= i)
                    continue;

                pq.add(new Node(i, j, cost));
            }
        }

        StringBuilder sb = new StringBuilder(); // 결과 출력을 StringBuilder에 저장

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int start = find(cur.start);
            int end = find(cur.end);

            if (cur.cost < 0) {
                union(start, end);
                mst += -cur.cost;
            } else if (start != end) {
                union(start, end);
                if (cur.cost > 0) {
                    mst += cur.cost;
                    cnt++;
                    sb.append(cur.start).append(" ").append(cur.end).append("\n"); // StringBuilder에 철도 경로 추가
                }
            }
        }

        bw.write(mst + " " + cnt + "\n"); // mst와 cnt 먼저 출력
        bw.write(sb.toString()); // 그 다음 철도 경로 출력
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parents[y] = x;
        } else
            parents[x] = y;
    }

    static class Node implements Comparable<Node> {
        int start, end, cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

}