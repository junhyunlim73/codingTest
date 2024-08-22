import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dh = {0, 0, 0, 0, -1, 1}; // 상하 이동
    static int[] dr = {1, -1, 0, 0, 0, 0}; // 전후 이동
    static int[] dc = {0, 0, 1, -1, 0, 0}; // 좌우 이동
    static int[][][] boxes; // 상자들을 나타내는 3차원 배열
    static boolean[][][] visited; // 방문 여부를 기록하는 3차원 배열
    static int H, N, M; // 3차원 배열의 크기 (높이, 행, 열)
    static int day = 1; // 최대 일수를 기록할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0; // 익지 않은 토마토의 개수를 세는 변수
        Queue<int[]> q = new LinkedList<>(); // BFS를 위한 큐

        // 3차원 배열의 크기 입력
        M = Integer.parseInt(st.nextToken()); // 열의 크기
        N = Integer.parseInt(st.nextToken()); // 행의 크기
        H = Integer.parseInt(st.nextToken()); // 높이 (층의 수)

        // 상자 배열과 방문 배열 초기화
        boxes = new int[H][N][M];
        visited = new boolean[H][N][M];

        // 상자 배열을 채우고 익은 토마토(1)의 위치를 큐에 추가
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());

                    if(boxes[i][j][k] == 1) {
                        // 토마토가 익은 경우, 그 위치를 큐에 추가
                        q.add(new int[]{i, j, k});
                        visited[i][j][k] = true; // 방문 처리
                    } else if(boxes[i][j][k] == 0) {
                        // 익지 않은 토마토의 개수를 세기
                        cnt++;
                    }
                }
            }
        }

        // BFS를 통해 익지 않은 토마토를 익히기
        while(!q.isEmpty()) {
            int[] cur = q.poll(); // 현재 위치를 큐에서 꺼냄

            for(int i = 0; i < 6; i++) { // 6방향(위, 아래, 좌, 우, 앞, 뒤)을 확인
                int nh = cur[0] + dh[i];
                int nr = cur[1] + dr[i];
                int nc = cur[2] + dc[i];

                // 범위를 벗어나는 경우, 무시하고 다음 방향으로
                if(nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                // 익지 않은 토마토이며 아직 방문하지 않은 경우
                if(boxes[nh][nr][nc] == 0 && !visited[nh][nr][nc]) {
                    q.add(new int[]{nh, nr, nc}); // 새로운 위치를 큐에 추가
                    boxes[nh][nr][nc] = boxes[cur[0]][cur[1]][cur[2]] + 1; // 익는 날을 업데이트
                    day = Math.max(day, boxes[nh][nr][nc]); // 최대 일수를 기록
                    visited[nh][nr][nc] = true; // 방문 처리
                    cnt--; // 익지 않은 토마토의 개수를 감소
                }
            }
        }

        // 모든 토마토가 익었으면 걸린 일수를 출력, 그렇지 않으면 -1 출력
        System.out.println(cnt == 0 ? day - 1 : -1);
    }
}