import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] ags) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Lecture(n, s, e));
        }

        while(!pq.isEmpty()){
            int rank = pq2.size() + 1;
            Lecture lecture = pq.poll();

            if(!pq2.isEmpty() && pq2.peek()[1] <= lecture.s_time){
                int[] q = pq2.poll();
                rank = q[0];
            }

            arr[lecture.no] = rank;
            pq2.add(new int[]{rank, lecture.e_time});
        }

        bw.write(pq2.size() + "\n");

        for(int i = 1; i < N+1; i++){
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Lecture implements Comparable<Lecture>{
        int no, s_time, e_time;

        public Lecture(int no, int s_time, int e_time){
            this.no = no;
            this.s_time = s_time;
            this.e_time = e_time;
        }

        public int compareTo(Lecture o){
            if(this.s_time == o.s_time){
                return Integer.compare(this.no, o.no);
            }
            return Integer.compare(this.s_time, o.s_time);
        }
    }

}