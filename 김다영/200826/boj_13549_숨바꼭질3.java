package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13549_숨바꼭질3 {
	static int N, K;
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken().trim());
		K = Integer.parseInt(st.nextToken().trim());
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Hide> q = new LinkedList<>();
		q.offer(new Hide(N, 0));
		visited[N] = true;
		int[] arr = {-1, 1};
		int a, position, time;
		Hide tmp;
		while(!q.isEmpty()) {
			tmp = q.poll();
			position = tmp.x;
			time = tmp.time;
			if(position == K) {
				return tmp.time;
			}
			a = 2 * position;
			if(a <= 100000 && !visited[a]) {
				q.offer(new Hide(a, time));
				visited[a] = true;
			}
			for(int i = 0; i < 2; i++) {
				a = position + arr[i];
				if(0<= a && a <= 100000 && !visited[a]) {
					q.offer(new Hide(a, time+1));
					visited[a] = true;
				}
			}
		}
		return 0;
	}
}
class Hide{
	int x, time;
	public Hide(int x, int time) {
		this.x = x;
		this.time = time;
	}
}