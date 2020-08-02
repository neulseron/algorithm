package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2156_포도주시식_v2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[] dp = new int[n]; // 계산 결과 저장
		int[] arr = new int[n]; // 포도주 양 데이터
		arr[0] = Integer.parseInt(br.readLine().trim());
		dp[0] = arr[0];
		// 포도주가 1잔인 경우
		if(n == 1) {
			System.out.println(arr[0]);
			return;
		}
		arr[1] = Integer.parseInt(br.readLine().trim());
		dp[1] = arr[0] + arr[1];
		// 포도주가 2잔인 경우 (2잔 더하기)
		if(n == 2) {
			System.out.println(dp[1]);
			return;
		}
		// 포도주가 3잔인 경우(3가지 중 최댓값)
		arr[2] = Integer.parseInt(br.readLine().trim());
		dp[2] = Math.max(dp[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));
		if(n == 3) {
			System.out.println(dp[2]);
			return;
		}
		// 입력과 동시에 처리
		for(int i = 3; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]));
		}
		System.out.println(dp[n-1]);
	}
}