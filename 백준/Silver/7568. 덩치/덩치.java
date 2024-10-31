import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] rank;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        rank = new int[N];
        Arrays.fill(rank, 1);
        People[] peoples = new People[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            peoples[i] = new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j)
                    continue;
                if(peoples[i].cm > peoples[j].cm && peoples[i].weight > peoples[j].weight){
                    rank[j]++;
                }
            }
        }


        for(int i = 0; i < N; i++){
            bw.write(rank[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class People{
        int weight, cm;

        public People(int weight, int cm){
            this.weight = weight;
            this.cm = cm;
        }

    }
}