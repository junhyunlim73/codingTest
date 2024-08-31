import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static LinkedHashMap<String, ArrayList<String>> adj;
    static LinkedHashMap<String, ArrayList<String>> result;
    static LinkedHashMap<String, Integer> map;
    static int[] inDegree;
    static int N, M, rootCnt;
    static String root = "";
    static String[] names;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        inDegree = new int[N];
        adj = new LinkedHashMap<>();
        result = new LinkedHashMap<>();
        map = new LinkedHashMap<>();
        names = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            names[i] = st.nextToken();
        }

        Arrays.sort(names);

        for(int i = 0; i < N; i++) {
            map.put(names[i], i);
            adj.put(names[i], new ArrayList<>());
            result.put(names[i], new ArrayList<>());
        }

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();
            int c_idx = map.get(child);
            int p_idx = map.get(parent);
            inDegree[c_idx]++;
            adj.get(names[p_idx]).add(names[c_idx]);
        }

        for(int i = 0; i < N; i++) {
            if(inDegree[i] == 0) {
                rootCnt++;
                root += names[i] + " ";
                q.add(i);
            }
        }

        sb.append(rootCnt).append("\n").append(root).append("\n");

        while(!q.isEmpty()) {
            int now = q.poll();
            String name = names[now];

            for(String child : adj.get(name)) {
                inDegree[map.get(child)]--;

                if(inDegree[map.get(child)] == 0) {
                    q.add(map.get(child));
                    result.get(name).add(child);
                }
            }
        }

        for(String name : result.keySet()) {
            sb.append(name).append(" ");
            ArrayList<String> list = result.get(name);
            Collections.sort(list);
            sb.append(list.size()).append(" ");

            for(int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}