import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 인접 리스트 배열, 부품 수, 관계 수, 필요한 부품 수량, 진입 차수, 중간 부품 여부를 나타내는 배열 선언
    static ArrayList<Node>[] adj;
    static int N, M;
    static int[] need;
    static int[] inDegree;
    static boolean[] mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 부품 수(N)과 관계 수(M) 입력받기
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 각 배열 초기화
        adj = new ArrayList[N + 1];
        mid = new boolean[N + 1];
        inDegree = new int[N + 1];
        need = new int[N + 1];

        // 인접 리스트 초기화
        for(int i = 0; i < N + 1; i++){
            adj[i] = new ArrayList<>();
        }

        // 관계 정보 입력받기
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());  // 부품 X
            int Y = Integer.parseInt(st.nextToken());  // 부품 Y (X를 만들기 위해 필요한 부품)
            int Z = Integer.parseInt(st.nextToken());  // X를 만들기 위해 필요한 Y의 개수
            adj[X].add(new Node(Y, Z));  // 인접 리스트에 관계 추가
            inDegree[Y]++;  // Y의 진입 차수 증가
            mid[X] = true;  // X를 중간 부품으로 설정
        }

        // 위상 정렬을 위한 큐 선언
        Queue<Integer> q = new ArrayDeque<>();

        // 진입 차수가 0인 부품을 큐에 추가하고 필요 수량을 1로 초기화
        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0){
                q.add(i);
                need[i] = 1;  // 하나가 기본적으로 필요
            }
        }

        // 위상 정렬 진행
        while(!q.isEmpty()){
            int now = q.poll();  // 현재 처리 중인 부품

            // 현재 부품(now)이 필요로 하는 다른 부품들에 대해 처리
            for(Node next : adj[now]){
                // 다음 부품(next.vertex)의 필요 수량 계산
                need[next.vertex] += need[now] * next.count;
                // 현재 부품을 사용했으므로 진입 차수 감소
                inDegree[next.vertex]--;

                // 진입 차수가 0이 되면 큐에 추가
                if(inDegree[next.vertex] == 0){
                    q.add(next.vertex);
                }
            }
        }

        // 중간 부품이 아닌 기본 부품들에 대해 필요 수량을 출력
        for(int i = 1; i <= N; i++){
            if(!mid[i]){
                System.out.println(i + " " + need[i]);
            }
        }

        br.close();
    }

    // 부품과 해당 부품의 수량을 나타내는 클래스
    static class Node{
        int vertex;  // 부품 번호
        int count;   // 필요한 수량

        public Node(int vertex, int count){
            this.vertex = vertex;
            this.count = count;
        }
    }
}