package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1261_알고스팟 {
	static int M, N; // M : 가로, N : 세로
	static int[][] data; // 미로 정보 저장 배열
	static int[][] min_cnt; // 방까지 벽을 부순 최소 횟수
	static int[] dx = {-1, 0, 1 ,0}; // 상 우 하 좌
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception{
		// 입력을 위함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 공백을 기준으로 데이터 구분
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로, 세로 길이 저장
		M = Integer.parseInt(st.nextToken().trim());
		N = Integer.parseInt(st.nextToken().trim());
		// 데이터 저장 배열 선언
		data = new int[N][M];
		min_cnt = new int[N][M];
		// 임시 문자열 저장
		String str;
		// 데이터 입력
		for(int i = 0; i < N; i++) {
			// 입력 데이터 한 줄 읽어옴
			str = br.readLine();
			for(int j = 0; j < M; j++) {
				// int형으로 저장해야 하기 때문에 '0'을 빼준 값으로 저장
				data[i][j] = str.charAt(j) - '0';
				// 최댓값으로 초기화
				min_cnt[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs();
		System.out.println(min_cnt[N-1][M-1]);
	}
	private static void bfs() {
		// bfs탐색을 위한 큐 생성
		Queue<Maze> q = new LinkedList<>();
		// 시작 좌표가 1,1이지만 배열의 시작이 0,0이기 때문에 변형하여 저장
		// 현재까지 벽을 부순 횟수 역시 0이기 때문에 0 저장
		q.offer(new Maze(0,0,0));
		min_cnt[0][0] = 0;
		// 큐에서 꺼낸 값을 처리하기 위한 임시 변수
		Maze m;
		// 현재 좌표, 이동할 좌표
		int x, y, nx, ny;
		// 큐가 빌 때까지
		while(!q.isEmpty()) {
			// 큐에서 데이터 꺼내기
			m = q.poll();
			// 현재 좌표 저장
			x = m.x;
			y = m.y;
			// 4방 탐색
			for(int i = 0; i < 4; i++) {
				// 이동할 좌표 계산
				nx = x + dx[i];
				ny = y + dy[i];
				// 이동할 좌표가 범위 내에 있다면
				if(0<= nx && nx < N && 0 <= ny && ny < M) {
					// 빈 방이라면
					if(data[nx][ny] == 0) {
						// 지금까지 벽을 부순 최소 횟수보다 현재 횟수가 더 적다면
						if(min_cnt[nx][ny] > m.cnt) {
							// 최솟값을 변경
							min_cnt[nx][ny] = m.cnt;
							// 큐에 데이터 삽입
							q.offer(new Maze(nx, ny, m.cnt));
						}
					}else { // 벽이라면
						// 지금까지 벽을 부순 최소 횟수보다 현재 횟수+1이 더 적다면
						// +1을 한 이유는 지금 좌표가 벽이기 때문에 이를 부수는 횟수까지 포함
						if(min_cnt[nx][ny] > (m.cnt+1)) {
							// 최솟값 변경
							min_cnt[nx][ny] = m.cnt+1;
							// 큐에 삽입
							q.offer(new Maze(nx, ny, m.cnt+1));
						}
					}
				}
			}// end 4방 탐색
		}// end while문
	}// end bfs
}
// 이동을 진행하면서 벽을 부순 횟수와 좌표를 저장하기 위한 객체
class Maze{
	// 데이터 필드
	int x, y, cnt;
	// 생성자
	public Maze(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}