package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178_미로탐색 {
	static int[][] data;
	static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static int N, M, answer;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken().trim());
		M = Integer.parseInt(st.nextToken().trim());
		String str;
		data = new int[N][M];
		visited = new boolean[N][M];
		// 데이터 입력
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < M; j++) {
				data[i][j] = str.charAt(j) - '0';
			}
		}
		bfs();
		System.out.println(answer);
	}
	private static void bfs() {
		Queue<MazeSearch> q = new LinkedList<>();
		q.offer(new MazeSearch(0,0,1));
		visited[0][0] = true;
		MazeSearch m;
		int x, y, nx, ny;
		while(true) {
			m = q.poll();
			x = m.x;
			y = m.y;
			if(x == N-1 && y == M-1)
				break;
			// 4방 탐색
			for(int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(data[nx][ny] == 1 && visited[nx][ny] == false) {
						visited[nx][ny] = true;
						q.offer(new MazeSearch(nx,ny,m.cnt+1));
					}
				}
			}
		}
		answer = m.cnt;
	}
}
class MazeSearch{
	int x, y, cnt;
	public MazeSearch(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
