import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int i, j;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split("");
        i = 0;
        j = str.length - 1;
        while(i < j){
            if(str[i].equals(str[j])){
                i++;
                j--;
            }else{
                flag = true;
                break;
            }
        }
        System.out.println(!flag ? 1 : 0);
        br.close();
    }
}