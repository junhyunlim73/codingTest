import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        char[] ham = br.readLine().toCharArray();
        boolean[] visited = new boolean[ham.length];
        int cnt = 0;

        for(int i = 0; i < N; i++){
            if(ham[i] == 'P'){
                boolean flag = false;
                for(int j = K; j >=1; j--){
                    int index = i - j;
                    if(index < 0)
                        continue;
                    else if(ham[index] == 'H' && !visited[index]){
                        cnt++;
                        visited[index] = true;
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    for(int j = 1; j <= K; j++){
                        int index = i + j;
                        if(index >= N)
                            continue;
                        else if(ham[index] == 'H' && !visited[index]){
                            cnt++;
                            visited[index] = true;
                            break;
                        }
                    }
                }

            }
        }

        System.out.println(cnt);
        br.close();
    }
}