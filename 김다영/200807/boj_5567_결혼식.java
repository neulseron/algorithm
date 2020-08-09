package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5567_결혼식 {
	static int cnt, n; // 초대할 동기 수
	static boolean[][] friends; // 동기 정보 저장
	static boolean[] visited; // 이미 체크한 동기인지 확인

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine().trim());
		int m = Integer.parseInt(br.readLine().trim());
		friends = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];
		int from, to;
		// 무향 데이터 입력
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken().trim());
			to = Integer.parseInt(st.nextToken().trim());
			friends[from][to] = true;
			friends[to][from] = true;
		}
		// 상근이 학번이 1이기 때문
		bfs(1);
		System.out.println(cnt);
	}
	private static void bfs(int person) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(person);
		visited[person] = true;
		int level = 1;
		int tmp, size;
		// 친구의 친구까지만 체크
		while(level <= 2) {
			size = q.size();
			for(int k = 0; k < size; k++) {
				tmp = q.poll();
				for(int i = 1; i <= n; i++) {
					if(friends[tmp][i] && !visited[i]) {
						q.offer(i);
						visited[i] = true;
						++cnt;
					}
				}
			}
			++level;
		}
	}
}
