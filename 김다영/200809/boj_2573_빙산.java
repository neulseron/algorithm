package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2573_빙산 {
	static boolean[][] visited;
	static int N, M, index;
	static Queue<Iceburg> q = new LinkedList<>(); // bfs 탐색을 위한 큐
	static int[][] data; // 빙산 정보를 받을 변수
	static ArrayList<Iceburg> list; // 빙산 정보를 저장할 변수
	static int[] dx = {-1,0,1,0}; // 상 우 하 좌
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken().trim());
		M = Integer.parseInt(st.nextToken().trim());
		data = new int[N][M];
		// answer : 빙산이 분리되는 최초의 시간
		// area : 빙산 구역 수, iceCnt : 빙산 개수
		int answer = 0, area = 0, iceCnt = 0;
		// 데이터 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken().trim());
				// 빙산 수 저장
				if(data[i][j] != 0)
					++iceCnt;
			}
		}
		// size : list사이즈, x,y : 좌표, h: 빙산의 높이, m : 줄일 높이
		int size, x, y, h, m;
		while(true) {
			visited = new boolean[N][M]; // 방문 배열 초기화
			list = new ArrayList<>(); // list 초기화
			index = 0; // 리스트에 접근할 index변수
			area = 0; // 빙산 구역 수 초기화
			BFS:
			// 첫 행,열 & 마지막 행,열은 바다이므로
			for(int i = 1; i < N-1; i++) {
				for(int j = 1; j < M-1; j++) {
					// 빙산이고 방문한 적이 없다면
					if(data[i][j] != 0 && !visited[i][j]) {
						// 큐와 리스트에 삽입하고 방문 처리
						q.offer(new Iceburg(i, j));
						list.add(new Iceburg(i, j));
						visited[i][j] = true;
						// 탐색 진행
						bfs();
						// 빙산 구역 수 증가
						area++;
						// 탐색된 빙산 수만큼 빼주기
						iceCnt -= list.size();
						// 남은 빙산 수가 0이라면 전체 for문 빠져나오기
						if(iceCnt == 0)
							break BFS;
					}
				}
			}
			// 빙산이 분리됨. 빙산 구역이 2개 이상이라면
			if(area > 1) {
				break;
			}
			// 시간 증가
			++answer;
			size = list.size();
			// 빙산이 모두 녹음
			if(size == 0) {
				// 분리될 수 없으므로 0으로 초기화 후 break
				answer = 0;
				break;
			}
			// 빙산 수 초기화
			iceCnt = 0;
			for(int i = 0; i < size; i++) {
				x = list.get(i).x;
				y = list.get(i).y;
				h = data[x][y];
				m = list.get(i).minus;
				// 빙산의 높이가 줄일 높이보다 높으면
				if(h > m) {
					// 차이로 높이 초기화
					data[x][y] = h - m;
					// 빙산 수 증가
					++iceCnt;
				}
				else // 낮으면
					// 높이 0으로 바꿈. 즉, 바다로 변경
					data[x][y] = 0;
			}
			// 빙산이 없다면
			if(iceCnt == 0) {
				// 분리될 수 없으므로 0으로 초기화 후 break
				answer = 0;
				break;
			}
		}
		System.out.println(answer);
	}
	private static void bfs() {
		Iceburg ib;
		int x,y,nx,ny;
		while(!q.isEmpty()) {
			ib = q.poll();
			x = ib.x;
			y = ib.y;
			// 4방 탐색
			for(int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				// 범위 내에 있다면
				if(0<= nx && nx < N && 0 <= ny && ny < M) {
					// 빙산이고
					if(data[nx][ny] != 0) {
						//방문한 적 없다면
						if(!visited[nx][ny]) {
							// 큐와 리스트에 삽입
							q.offer(new Iceburg(nx, ny));
							list.add(new Iceburg(nx, ny));
							// 해당 위치 방문처리
							visited[nx][ny] = true;
						}
					}else {// 바다라면
						// 줄일 높이에 1 더하기
						list.get(index).SetMinus(1);
					}
				}
			}
			// list 접근 index 증가
			index++;
		}
	}
}
// 빙산 정보 저장 객체
class Iceburg{
	int x, y, minus;
	public Iceburg(int x, int y) {
		this.x = x;
		this.y = y;
		this.minus = 0;
	}
	public void SetMinus(int m) {
		this.minus += m;
	}
}