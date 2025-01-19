import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[][] nutrientes;
    static int[] prices, sums;
    static int[] sel;
    static int N;
    static int mp, mf, ms, mv;
    static int min = Integer.MAX_VALUE;
    static ArrayList<String> list;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nutrientes = new int[N][4];
        sums = new int[4];
        prices = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            nutrientes[i][0] = Integer.parseInt(st.nextToken());
            nutrientes[i][1] = Integer.parseInt(st.nextToken());
            nutrientes[i][2] = Integer.parseInt(st.nextToken());
            nutrientes[i][3] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            sel = new int[i+1];
            combi(0, 0, i+1, 0);
        }

        if(!flag){
            System.out.println("-1");
        }else{
            sb.append(min).append("\n");
            Collections.sort(list);
            sb.append(list.get(0));

            System.out.println(sb);
        }

        br.close();
    }

    private static void combi(int depth, int idx, int target, int sum){
        if(depth == target){
            if(mp <= sums[0] && mf <= sums[1] && ms <= sums[2] && mv <= sums[3]){
                if(min != sum){
                    min = sum;
                    list = new ArrayList<>();
                }

                String str = "";

                flag = true;

                for(int n : sel){
                    str += String.valueOf(n+1) + " ";
                }

                list.add(str);
            }

            return;
        }

        if(idx == N)
            return;

        for(int i = idx; i < N; i++){
            if(sum + prices[i] <= min){
                sel[depth] = i;
                sums[0] += nutrientes[i][0];
                sums[1] += nutrientes[i][1];
                sums[2] += nutrientes[i][2];
                sums[3] += nutrientes[i][3];
                combi(depth+1, i+1, target, sum+prices[i]);
                sums[0] -= nutrientes[i][0];
                sums[1] -= nutrientes[i][1];
                sums[2] -= nutrientes[i][2];
                sums[3] -= nutrientes[i][3];
            }
        }

    }

}