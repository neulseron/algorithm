package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576_토마토 {
	static int[][] tomato;
	static int cnt = -1, M, N, zero;
	static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static boolean check = true; // 모든 토마토가 익었는지 판단
	static Queue<Tomato> q;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		q = new LinkedList<>();
		M = Integer.parseInt(st.nextToken().trim());
		N = Integer.parseInt(st.nextToken().trim());
		tomato = new int[N][M];
		visited = new boolean[N][M];
		int input;
		// 데이터 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				input = Integer.parseInt(st.nextToken().trim());
				if(input == 1) {
					q.offer(new Tomato(i,j));
					visited[i][j] = true;
				}
				else if(input == 0)
					zero++;
				tomato[i][j] = input;
			}
		}
		// 익지 않은 토마토가 없다면
		if(zero == 0) {
			System.out.println(0);
			return;
		}
		bfs();
		// 모든 토마토가 익었다면
		if(check)
			System.out.println(cnt);
		else // 익지 못했다면
			System.out.println(-1);
	}

	private static void bfs() {
		Tomato tmp;
		int nx, ny, size, num = 0;
		while(!q.isEmpty()) {
			cnt++;
			size = q.size();
			for(int k = 0; k < size; k++) {
				tmp = q.poll();
				// 4방
				for(int i = 0; i < 4; i++) {
					nx = tmp.x + dx[i];
					ny = tmp.y + dy[i];
					if(0 <= nx && nx < N && 0 <= ny && ny < M) {
						// 익지 않았고 방문하지 않았다면
						if(tomato[nx][ny] == 0 && !visited[nx][ny]) {
							q.add(new Tomato(nx, ny));
							visited[nx][ny] = true;
							num++;
						}
					}
				}
			}
		}
		if(num != zero)
			check = false;
	}
}
class Tomato{
	int x, y;
	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}