import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N, M;
    static int[] A, B;
    static long cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> Alist = new ArrayList<Integer>();
        List<Integer> Blist = new ArrayList<Integer>();

        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = i; j < N; j++) {
                sum += A[j];
                Alist.add(sum);
            }
        }

        for(int i = 0; i < M; i++) {
            int sum = 0;
            for(int j = i; j < M; j++) {
                sum += B[j];
                Blist.add(sum);
            }
        }

        Collections.sort(Alist);
        Collections.sort(Blist);

        int AIdx = 0, BIdx = Blist.size() - 1;
        int size = Alist.size();

        while(AIdx < size && BIdx >= 0) {
            int num1 = Alist.get(AIdx);
            int num2 = Blist.get(BIdx);

            int sum = num1 + num2;

            if(sum < T){
                AIdx++;
            }else if(sum > T){
                BIdx--;
            }else{
                long aCnt = 0;
                long bCnt = 0;

                while(AIdx < size && Alist.get(AIdx) == num1) {
                    AIdx++;
                    aCnt++;
                }

                while(BIdx >= 0 && Blist.get(BIdx) == num2) {
                    BIdx--;
                    bCnt++;
                }

                cnt += aCnt * bCnt;
            }

        }

        System.out.println(cnt);
        br.close();
    }

}