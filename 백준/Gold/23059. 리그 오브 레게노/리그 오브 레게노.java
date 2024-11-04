import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, ArrayList<String>> map = new HashMap<>();
    static HashMap<String, Integer> inDegrees = new HashMap<>();
    static int N;
    static int total;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Item> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            inputList(map, first);
            inputList(map, second);
            map.get(first).add(second);

            inputInDegrees(inDegrees, first);
            inputInDegrees(inDegrees, second);
            inDegrees.put(second, inDegrees.getOrDefault(second, 0) + 1);
        }

        for(String s : inDegrees.keySet()) {
            if(inDegrees.get(s) == 0) {
                pq.add(new Item(s, 0));
            }
        }

        while(!pq.isEmpty()) {
            Item item = pq.poll();
            sb.append(item.name).append("\n");

            cnt++;
            ArrayList<String> list = map.get(item.name);

            for(String name : list) {
                inDegrees.put(name, inDegrees.getOrDefault(name, 0) - 1);

                if(inDegrees.get(name) == 0) {
                    pq.add(new Item(name, item.depth+1));
                }
            }

        }

        if(total == cnt) {
            System.out.println(sb.toString());
        }else{
            System.out.println(-1);
        }

        br.close();
    }

    private static void inputList(HashMap<String, ArrayList<String>> map, String key) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
            total++;
        }
    }

    private static void inputInDegrees(HashMap<String, Integer> map, String key) {
        if(!map.containsKey(key)) {
            map.put(key, 0);
        }
    }

    static class Item implements Comparable<Item> {
        String name;
        int depth;

        public Item(String name, int depth) {
            this.name = name;
            this.depth = depth;
        }

        public int compareTo(Item o) {
            if(this.depth == o.depth) {
                return this.name.compareTo(o.name);
            }
            return Integer.compare(this.depth, o.depth);
        }
    }

}