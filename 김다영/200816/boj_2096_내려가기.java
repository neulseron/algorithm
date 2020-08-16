package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2096_내려가기 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] data = new int[3];
		int[][] min_data = new int[2][3];
		int[][] max_data = new int[2][3];
		// 데이터 입력 & 처리
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				data[j] = Integer.parseInt(st.nextToken().trim());
			}
			if(i == 0) {
				max_data[0][0] = min_data[0][0] = data[0];
				max_data[0][1] = min_data[0][1] = data[1];
				max_data[0][2] = min_data[0][2] = data[2];
			}
			else {
				min_data[1][0] = Math.min(min_data[0][0], min_data[0][1]) + data[0];
				max_data[1][0] = Math.max(max_data[0][0], max_data[0][1]) + data[0];
				
				min_data[1][1] = Math.min(min_data[0][0], Math.min(min_data[0][1], min_data[0][2])) + data[1];
				max_data[1][1] = Math.max(max_data[0][0], Math.max(max_data[0][1], max_data[0][2])) + data[1];
				
				min_data[1][2] = Math.min(min_data[0][1], min_data[0][2]) + data[2];
				max_data[1][2] = Math.max(max_data[0][1], max_data[0][2]) + data[2];

				for(int k = 0; k < 3; k++) {
					min_data[0][k] = min_data[1][k];
					max_data[0][k] = max_data[1][k];
				}
			}
		}
		int min = Math.min(min_data[0][0], Math.min(min_data[0][1], min_data[0][2]));
		int max = Math.max(max_data[0][0], Math.max(max_data[0][1], max_data[0][2]));
		System.out.println(max + " " + min);
	}
}