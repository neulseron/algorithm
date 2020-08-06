package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1389_케빈베이컨의6단계법칙 {
	static boolean[][] person;
	static boolean[] visited;
	static Queue<Integer> q;
	static int N, min = Integer.MAX_VALUE, min_person = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken().trim());
		int M = Integer.parseInt(st.nextToken().trim());
		person = new boolean[N + 1][N + 1];
		int from, to;
		// 입력. 무향 그래프. 양방향.
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken().trim());
			to = Integer.parseInt(st.nextToken().trim());
			person[from][to] = true;
			person[to][from] = true;
		}
		// 1~N까지 사람들의 케빈베이컨의 수 계산
		for(int i = 1; i <= N; i++) {
			q = new LinkedList<>();
			visited = new boolean[N + 1];
			visited[i] = true;
			for(int j = 1; j <= N; j++) {
				if(i == j)
					continue;
				if(person[i][j]) {
					q.add(j);
					visited[j] = true;
				}
			}
			bfs(i);
		}
		System.out.println(min_person);
	}

	private static void bfs(int num) {
		int size, level = 1;
		int tmp, cnt = 0;
		while(!q.isEmpty()) {
			size = q.size();
			cnt += (size * level++); // 큐의 크기 * 레벨
			for(int i = 0; i < size; i++) {
				tmp = q.poll();
				for(int j = 1; j <= N; j++) {
					// 친구이고 방문한 적 없는 친구라면
					if(person[tmp][j] && !visited[j]) {
						q.add(j);
						visited[j] = true;
					}
				}
			}
		}
		// 더 적은 케빈 베이컨의 수를 가진 사람이라면 change
		if(min > cnt) {
			min = cnt;
			min_person = num;
		}else if(min == cnt) { // 같은 수를 가진 사람이라면 번호만 변경
			if(min_person > num) {
				min_person = num;
			}
		}
	}
}
