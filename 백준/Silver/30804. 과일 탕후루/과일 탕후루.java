import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] cnts = new int[10];
    static boolean[] fruits = new boolean[10];
    static int type;
    static int N;
    static int[] S;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = 0;
        int endIdx = 0;
        int fruit = 0;

        while(endIdx < N){
            int num = S[endIdx];

            if(!fruits[num]){
                fruits[num] = true;
                cnts[num]++;
                fruit++;
                type++;
                endIdx++;
            }else{
                fruit++;
                cnts[num]++;
                endIdx++;
            }

            if(type <= 2)
                max = Math.max(max, fruit);
            else{
                int startNum = S[startIdx];
                fruit--;
                cnts[startNum]--;

                if(cnts[startNum] == 0){
                    fruits[startNum] = false;
                    type--;
                }

                startIdx++;
            }
        }

        System.out.println(max);
    }
}