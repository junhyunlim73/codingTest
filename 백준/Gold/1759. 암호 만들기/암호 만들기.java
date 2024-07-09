import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int L, C;
    static boolean[] checked;
    static StringBuilder sb = new StringBuilder();
    static String[] ch;
    static String aeiou = "aeiou";

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        checked = new boolean[C];
        ch = br.readLine().split(" ");
        Arrays.sort(ch);

        combi(0, 0, "",0 ,0 );
        System.out.println(sb.toString());
    }

    private static void combi(int index, int depth, String en, int cnt1, int cnt2){

        if(depth == L){
            if(cnt1 >= 1 && cnt2 >=2){
                sb.append(en+"\n");
            }

            return;
        }

        if(index == C){
            return;
        }



        for(int i = index ; i < C; i++){
            if(aeiou.indexOf(ch[i]) != -1){
                combi(i+1, depth + 1, en+ch[i], cnt1 + 1, cnt2);
            }else{
                combi(i+1, depth + 1, en+ch[i], cnt1, cnt2 + 1);
            }
        }
    }
}