import java.util.*;
import java.io.*;

public class Solution {
	static int[][] board;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			cnt = 0;
			int N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j = 0; j < N; j++) {
				boolean flag = false;
				for(int i = 0; i < N; i++) {
					if(flag && board[i][j] == 2) {
						flag = false;
						cnt++;
					}else if(board[i][j] == 1) {
						flag =true;
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	
}