import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();
    static String[] sel;
    static String[] op = {" ", "+", "-"};
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            target = Integer.parseInt(br.readLine());
            sel = new String[target-1];
            perm(0);
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static void perm(int depth){
        if(depth == (target-1)){
            int sum = 0;
            int num = 1;
            int n = 2;

            for(int i = 0; i < sel.length; i++){
                if(sel[i].equals(" ")){
                    num *= 10;

                    if(num < 0)
                        num -= n;
                    else
                        num += n;
                    n++;
                }else{
                    sum += num;
                    if(sel[i].equals("+")){
                        num = n;
                    }else{
                        num = -n;
                    }
                    n++;
                }
            }

            if(num != 0){
                sum += num;
            }

            if(sum == 0){
                sb.append("1");
                for(int i = 0; i < sel.length; i++){
                    sb.append(sel[i]).append((i+2));
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = 0; i < op.length; i++){
            sel[depth] = op[i];
            perm(depth+1);
        }

    }
}