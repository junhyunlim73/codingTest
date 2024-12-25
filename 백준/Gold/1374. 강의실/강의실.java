import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Room> rooms = new ArrayList<Room>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            rooms.add(new Room(n, s, e));
        }

        Collections.sort(rooms);

        for(Room room : rooms) {

            if(!pq.isEmpty() && pq.peek() <= room.start) {
                pq.poll();
            }

            pq.add(room.end);
        }

        System.out.println(pq.size());
        br.close();
    }

    static class Room implements Comparable<Room> {
        int no, start, end;

        public Room(int no, int start, int end) {
            this.no = no;
            this.start = start;
            this.end = end;
        }

        public int compareTo(Room o) {
            if(this.start == o.start) {
                return Integer.compare(this.end, o.end);
            }
            return Integer.compare(start, o.start);
        }
    }
}