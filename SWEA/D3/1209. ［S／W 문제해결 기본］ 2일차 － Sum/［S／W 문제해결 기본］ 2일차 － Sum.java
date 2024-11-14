import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
		
			int T = Integer.parseInt(br.readLine());
			int[][] matrix = new int[100][100];
			int idx = 0;
			int[] sums = new int[202];
			
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < 100; i++) {
				int sum = 0;
				for(int j = 0; j < 100; j++) {
					sum += matrix[i][j];
				}
				sums[idx++] = sum;
			}
			
			for(int i = 0; i < 100; i++) {
				int sum = 0;
				for(int j = 0; j < 100; j++) {
					sum += matrix[j][i];
				}
				sums[idx++] = sum;
			}
			
			int sum = 0;
			
			for(int i = 0; i < 100; i++) {
				sum += matrix[i][i];
			}
			
			sums[idx++] = sum;
			
			sum = 0;
			
			for(int i = 0; i < 100; i++) {
				sum += matrix[i][99 - i];
			}
			
			sums[idx++] = sum;
			
			Arrays.sort(sums);
			
			sb.append("#"+T).append(" ").append(sums[201]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}