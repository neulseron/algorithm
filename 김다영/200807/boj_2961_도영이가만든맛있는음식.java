package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2961_도영이가만든맛있는음식 {
	static boolean[] visited;
	static int N, min = Integer.MAX_VALUE;
	static int[][] data;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		data = new int[N][2]; // 신맛, 쓴맛
		visited = new boolean[N];
		// 데이터 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken().trim());
			data[i][1] = Integer.parseInt(st.nextToken().trim());
		}
		subset(0);
		System.out.println(min);
	}
	
	private static void subset(int cnt) {
		if(cnt == N) {
			int S = 1;
			int B = 0;
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					S *= data[i][0];
					B += data[i][1];
				}
			}
			// 공집합 제외
			if(B != 0) {
				int result = Math.abs(S-B);
				min = (min > result) ? result : min;
			}
			return;
		}
		
		visited[cnt] = true;
		subset(cnt + 1);
		
		visited[cnt] = false;
		subset(cnt + 1);
	}
}
