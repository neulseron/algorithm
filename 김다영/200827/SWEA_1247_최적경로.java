package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {
	
	static int N, sum, cnt, min = Integer.MAX_VALUE;
	static int[][] point;
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine().trim());
			point = new int[N+2][2];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N+2; i++) {
				point[i][0] = Integer.parseInt(st.nextToken().trim());
				point[i][1] = Integer.parseInt(st.nextToken().trim());
			}
			for(int i = 2; i < N+2; i++) {
				visit = new boolean[N+2];
				sum = distance(i, 0);
				visit[i] = true;
				cnt = 1;
				search(i);
			}
			System.out.println("#"+tc+" "+min);
		}
	}
	private static void search(int start) {
		for(int i = 2; i < N+2; i++) {
			if(start == i) continue;
			if(visit[i]) continue;
			sum += distance(start, i);
			if(sum > min) {
				sum -= distance(start,i);
				continue;
			}
			visit[i] = true;
			cnt++;
			search(i);
			sum -= distance(start, i);
			cnt--;
			visit[i] = false;
		}
		if(cnt == N) {
			int tmp = sum + distance(start, 1);
			min = min > tmp ? tmp : min;
		}
	}
	
	private static int distance(int num1, int num2) {
		return Math.abs(point[num1][0]-point[num2][0]) + Math.abs(point[num1][1]-point[num2][1]);
	}
}
