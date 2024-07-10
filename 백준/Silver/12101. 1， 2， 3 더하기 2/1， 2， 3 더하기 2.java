import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static ArrayList<String> answer;
    static int[] sel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = new ArrayList<>();

        for(int i = N; i >= 1; i--){
            sel = new int[i];
            perm(0, 0, i);
        }

        Collections.sort(answer);

        if(answer.size() < K) {
            System.out.println(-1);
        }else{
            System.out.println(answer.get(K - 1));
        }
    }

    private static void perm(int depth, int sum, int purpose){
        if(depth == purpose){
            if(sum == N){
                String str = "";

                for(int num : sel){
                    str += num + "+";
                }
                str = str.substring(0, str.length() - 1);
                answer.add(str);
            }

            return;
        }

        for(int i = 1; i <= 3; i++){
            sel[depth] = i;
            if((sum +i) <= N){
                perm(depth+1, sum+i, purpose);
            }
        }

    }
}