import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] sel;
    static int[] arr;
    static int k;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if(k == 0)
                break;

            sel = new int[6];
            arr = new int[k];

            for(int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            combi(0 , 0);
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static void combi(int index, int depth){
        if(depth == 6){
            for(int num : sel){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = index; i < k; i++){
            sel[depth] = arr[i];
            combi(i+1, depth+1);
        }

    }

}