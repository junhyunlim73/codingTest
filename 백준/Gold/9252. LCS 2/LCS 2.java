import java.io.*;
import java.util.ArrayDeque;

public class Main {
    static int[][] dp;
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str1 = br.readLine();
        str2 = br.readLine();

        dp = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int x = str1.length();
        int y = str2.length();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        while(x > 0 && y > 0){

            if(str1.charAt(x - 1) == str2.charAt(y - 1)){
                stack.push(str1.charAt(x - 1));
                x--;
                y--;
            } else if(dp[x][y] == dp[x-1][y]){
                x--;
            }else{
                y--;
            }

        }

        bw.write(stack.size() + "\n");

        while(!stack.isEmpty()){
            bw.write(stack.pop());
        }

        bw.flush();
        bw.close();
        br.close();
    }

}