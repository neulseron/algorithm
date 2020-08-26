package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// https://www.acmicpc.net/board/view/27386
public class BOJ_2206_벽부수고이동하기_another {
	static int[][] data;
	static int[][][] visited;
	static int N, M, answer = Integer.MAX_VALUE;
	static int[] dx = {-1, 0, 1, 0}; // 상우하좌
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str;
		N = Integer.parseInt(st.nextToken().trim());
		M = Integer.parseInt(st.nextToken().trim());
		data = new int[N][M];
		// 방문 배열 2개 선언
		// 0 : 벽을 부수지 않고 진행했을 때의 방문 상황 저장하는 배열
		// 1 : 벽을 부수고 진행했을 때의 방문 상황 저장하는 배열
		visited = new int[2][N][M];
		// 데이터 입력
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < M; j++) {
				data[i][j] = str.charAt(j) - '0';
			}
		}
		bfs();
//		if(visited[0][N-1][M-1] != 0 && visited[1][N-1][M-1] != 0) {
//			System.out.println(Math.min(visited[0][N-1][M-1], visited[1][N-1][M-1]));
//		}else if(visited[0][N-1][M-1] == 0 && visited[1][N-1][M-1] == 0) {
//			System.out.println(-1);
//		}else {
//			System.out.println(Math.max(visited[0][N-1][M-1], visited[1][N-1][M-1]));
//		}
			
		answer = answer == Integer.MAX_VALUE ? -1 : answer;
		System.out.println(answer);
	}
	
	private static void bfs() {
		Queue<Wall> q = new LinkedList<>();
		Wall w;
		int x, y, nx, ny;
		q.offer(new Wall(0,0,0));
		visited[0][0][0] = 1;
		while(!q.isEmpty()) {
			w = q.poll();
			x = w.x;
			y = w.y;
			if(x == N-1 && y == M-1) {
				answer = Math.min(answer, visited[w.check][x][y]);
				continue;
			}
			// 4방 탐색
			// 1) 다음 위치가 벽이 아니면 gogo
			// 2) 다음 위치가 벽인 경우 (아직 부순적없어야 가능, 1번 배열에 반영해야 함.)
			for(int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if(0<= nx && nx < N && 0 <= ny && ny < M) {
					if(data[nx][ny] == 1) {
						if(w.check == 0 && visited[1][nx][ny] == 0) {
							visited[1][nx][ny] = visited[w.check][x][y] + 1;
							q.offer(new Wall(nx, ny, w.check+1));
						}
					}else {
						if(visited[w.check][nx][ny] == 0) {
							visited[w.check][nx][ny] = visited[w.check][x][y] + 1;
							q.offer(new Wall(nx, ny, w.check));
						}
					}
				}
			}
		}
	}	
}
class Wall{
	int x, y, check;
	public Wall(int x, int y, int check) {
		this.x = x;
		this.y = y;
		this.check = check;
	}
}