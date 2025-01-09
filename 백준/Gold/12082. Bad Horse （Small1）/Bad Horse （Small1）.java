import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int nPair = Integer.parseInt(br.readLine().trim()); 
            Map<String, List<String>> graph = new HashMap<>();

            // 그래프 생성
            for (int i = 0; i < nPair; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                graph.putIfAbsent(a, new ArrayList<>());
                graph.putIfAbsent(b, new ArrayList<>());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            // 이분성 검사
            boolean isBipartite = check(graph);
            sb.append("Case #").append(t).append(": ").append(isBipartite ? "Yes" : "No").append("\n");
        }

        System.out.print(sb);
    }

    private static boolean check(Map<String, List<String>> graph) {
        Map<String, Integer> color = new HashMap<>();

        for (String vertex : graph.keySet()) {
            color.put(vertex, 0);
        }

        for (String vertex : graph.keySet()) {
            if (color.get(vertex) != 0) {
                continue;
            }

            ArrayDeque<String> q = new ArrayDeque<>();
            q.add(vertex);
            color.put(vertex, 1); // 시작 노드 색깔 지정

            while (!q.isEmpty()) {
                String current = q.poll();
                int currentColor = color.get(current);

                for (String neighbor : graph.get(current)) {
                    if (color.get(neighbor) == 0) {
                        color.put(neighbor, 3 - currentColor); 
                        q.add(neighbor);
                    } else if (color.get(neighbor).equals(currentColor)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}