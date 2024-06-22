import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] ele;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int f,s,g,u,d;

    public static void main(String[] args) throws IOException {
        Queue<Integer> q = new LinkedList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        ele = new int[f+1];
        visited = new boolean[f+1];

        q.add(s);
        visited[s] = true;

        while(!q.isEmpty()){
            int w = q.poll();
            int up = w + u;
            int down = w - d;

            if(up <= f && !visited[up]){
                ele[up] = ele[w] + 1;
                visited[up] = true;
                q.add(up);
            }

            if(down >= 1 && !visited[down]){
                ele[down] = ele[w] + 1;
                visited[down] = true;
                q.add(down);
            }
        }

        if(!visited[g])
            System.out.println("use the stairs");
        else
            System.out.println(ele[g]);

        br.close();
    }
}