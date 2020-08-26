package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 포도주 시식과 유사 (제한이 3이라는 것에서 유사)
 * 1. 한 계단 or 두 계단 오르는 2가지 방식 존재
 * 2. 한 계단은 dp[i-3] + arr[i-1] + arr[i]
 * 3. 두 계단은 dp[i-2] + arr[i]
 */
public class 김다영_BOJ_2579_계단오르기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[N];
		int[] dp = new int[N];
		// 3칸을 연속할 수 없기 때문에 N이 3이하인 경우 예외 처리
		if(N >= 1) {
			arr[0] = Integer.parseInt(br.readLine().trim());
			dp[0] = arr[0];
		}
		if(N >= 2) {
			arr[1] = Integer.parseInt(br.readLine().trim());
			dp[1] = dp[0] + arr[1];
		}
		if(N >= 3) {
			arr[2] = Integer.parseInt(br.readLine().trim());
			dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);
		}
		// 2가지 경우 중 큰 것 저장
		for(int i = 3; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
			dp[i] = arr[i];
			dp[i] += Math.max(dp[i-3] + arr[i-1], dp[i-2]);
		}
		System.out.println(dp[N-1]);
	}
}
