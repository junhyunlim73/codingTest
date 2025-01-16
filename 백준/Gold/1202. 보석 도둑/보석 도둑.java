import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static long total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewerly> jewerlies = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewerlies.add(new Jewerly(m, v));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        while (!bags.isEmpty()) {
            int bagWeight = bags.poll(); 
            
            while (!jewerlies.isEmpty() && jewerlies.peek().m <= bagWeight) {
                pq.add(jewerlies.poll().v); 
            }
            
            if (!pq.isEmpty()) {
                total += pq.poll();
            }
        }

        System.out.println(total);
        br.close();
    }

    static class Jewerly implements Comparable<Jewerly> {
        int m, v;

        public Jewerly(int m, int v) {
            this.m = m;
            this.v = v;
        }

        public int compareTo(Jewerly o) {
            if (this.m == o.m) {
                return Integer.compare(o.v, this.v); 
            }
            return Integer.compare(this.m, o.m); 
        }
    }
}