package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14501_퇴사 {
	static int max, N;
	static int[][] data;
	static Queue<Couns> q;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		data = new int[N][2];
		q = new LinkedList<>();
		// 데이터 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken().trim());
			data[i][1] = Integer.parseInt(st.nextToken().trim());
		}
		// 데이터 처리
		for(int i = 0; i < N; i++) {
			if(i + data[i][0] <= N) {
				q.offer(new Couns(i + data[i][0],data[i][1]));
				bfs();
			}
		}
		System.out.println(max);
	}

	private static void bfs() {
		Couns c;
		int size, T, P;
		while(!q.isEmpty()) {
			c = q.poll();
			T = c.T;
			P = c.P;
			size = q.size();
			for(int i = T; i < N; i++) {
				if(i + data[i][0] <= N)
					q.offer(new Couns(i + data[i][0], P + data[i][1]));
			}
			if(size == q.size())
				max = max < P ? P : max;
		}
	}
}
class Couns{
	int T, P;
	public Couns(int T, int P){
		this.T = T;
		this.P = P;
	}
}
