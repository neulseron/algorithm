package programming.baekjoon.no_9000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9663_NQueen {
	static int[] arr;
	static int N, cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		search(0);
		System.out.println(cnt);
	}
	
	private static void search(int row) {
		// 모든 행을 진행했다면, cnt++
		if(row >= N) {
			cnt++;
			return;
		}
		for(int i = 0; i < N; i++) {
			arr[row] = i;
			// 유망한지 확인 후 다음 진행
			if(promising(row)) {
				search(row+1);
			}
		}
	}
	
	private static boolean promising(int row) {
		for(int i = 0; i < row; i++) {
			// 같은 열과 대각선 위치면 false
			if(arr[i] == arr[row] || Math.abs(i-row) == Math.abs(arr[i]-arr[row]))
				return false;
		}
		return true;
	}

}
