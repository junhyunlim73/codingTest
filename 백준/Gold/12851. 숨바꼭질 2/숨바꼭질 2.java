import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited = new boolean[100001];
        q.add(new int[]{N, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int position = now[0];
            int time = now[1];

            visited[position] = true;

            // 최소 시간을 초과하면 더 이상 탐색할 필요가 없음
            if (time > min) continue;

            // 목표 지점에 도달했을 때
            if (position == M) {
                if (time < min) {
                    min = time;
                    cnt = 1;  // 새로운 최소 시간이 나오면 카운트를 초기화
                } else if (time == min) {
                    cnt++;  // 최소 시간에 도달하는 경로를 하나 더 찾음
                }
                continue;
            }

            // 다음 가능한 이동 경로 탐색
            if (position + 1 <= 100000 && !visited[position + 1]) {
                q.add(new int[]{position + 1, time + 1});
            }
            if (position - 1 >= 0 && !visited[position - 1]) {
                q.add(new int[]{position - 1, time + 1});
            }
            if (position * 2 <= 100000 && !visited[position * 2]) {
                q.add(new int[]{position * 2, time + 1});
            }
        }

        System.out.println(min);
        System.out.println(cnt);
        br.close();
    }
}