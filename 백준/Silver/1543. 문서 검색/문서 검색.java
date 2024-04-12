import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int i, cnt;
    static boolean flag;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String text = br.readLine();
        String target = br.readLine();
        i = 0;
        while(i < text.length() - target.length() + 1){
            flag = true;
            for(int p = 0; p < target.length(); p++){
                if(text.charAt(i + p) != target.charAt(p)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                cnt++;
                i += target.length();
            }else{
                i++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}