import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int cmd = Integer.parseInt(br.readLine());
			
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < cmd; i++) {
				String in = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int[] s = new int[y];
				
				for(int j = 0; j < y; j++) {
					s[j] = Integer.parseInt(st.nextToken());
				}
				
				for(int j = x; j < (x + y); j++) {
					int idx = j - x;
					list.add(j, s[idx]);
				}
				
			}
			
			sb.append("#").append(test_case).append(" ");
			
			for(int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}

}
