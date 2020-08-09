package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12865_평범한배낭 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken().trim());
		int K = Integer.parseInt(st.nextToken().trim());
		int[][] dp = new int[N + 1][K + 1];
		int w, v;
		// 각 물품이 포함되었을 때 무게별 최대 가치
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken().trim());
			v = Integer.parseInt(st.nextToken().trim());
			// 무게만큼 반복문 돌면서 각 물품의 무게와 비교하고 최댓값 계산
			for(int j = 1; j <= K; j++) {
				// 물품의 무게가 더 크면 이전 물품까지의 최대값 저장
				// 아니라면 이전까지의 최댓값과 (현재 무게 - 물품의 무게)의 이전 값 + 현재 가치 중 큰 값
				if(w > j)
					dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = Math.max(dp[i-1][j-w] + v, dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}