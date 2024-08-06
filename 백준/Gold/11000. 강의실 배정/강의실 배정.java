import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        PriorityQueue<Integer> list = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Lecture(s, e));
        }

        list.add(pq.poll().end);

        for(int i = 1; i < N; i++) {

            if(list.peek() <= pq.peek().start) { 
                list.poll();
            }

            list.add(pq.poll().end);
        }

        System.out.println(list.size());
    }

    static class Lecture implements Comparable<Lecture>{
        int start;
        int end;

        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Lecture lecture){ // 정렬
            if(this.start == lecture.start)
                return this.end - lecture.end;
            return this.start - lecture.start;
        }
    }

}