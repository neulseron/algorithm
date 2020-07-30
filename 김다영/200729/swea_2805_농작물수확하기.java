package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class swea_2805_농작물수확하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int N; // 농장의 크기
		int[][] data; // 농작물 가치
		String str;
		int start, sum;
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			sum = 0;
			N = Integer.parseInt(br.readLine());
			data = new int[N][N];
			for(int i = 0; i < N; i++) {
				str = br.readLine();
				for(int j = 0; j < N; j++) {
					data[i][j] = str.charAt(j) - 48;
				}
			}
			start = N / 2; // 중앙값
			for(int i = 0; i <= N/2; i++) { // 중앙까지의 행의 수
				for(int j = start - i; j <= start + i; j++) {
					sum += data[i][j];
				}
			}
			for(int i = N/2 - 1; i >= 0; i--) { // 중앙 이후의 행의 수
				for(int j = start - i; j <= start + i; j++) {
					sum += data[N-1-i][j];
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}