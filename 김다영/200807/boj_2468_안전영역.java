package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2468_안전영역 {
	static boolean[][] visited; // 방문여부
	static Queue<Nodes> q; // bfs를 위한 변수
	static int[][] data; // 
	static int[] dx = {-1,0,1,0};// 상 우 하 좌
	static int[] dy = {0,1,0,-1};
	static int N;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 버퍼 생성
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim()); // 영역의 가로길이
		data = new int[N][N]; // 높이를 저장하는 배열
		int max = 0, cnt, answer = 0; // max : 최대 높이, cnt : 각 높이에서 영역 수, answer : 최대 영역 수
		// 데이터 입력 , 최대 높이 저장
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken().trim());
				max = (max < data[i][j])?data[i][j]:max;
			}
		}
		// 최대 높이가 1이라면
		if(max == 1) {
			System.out.println(1);
			return;
		}
		// 높이가 1~max까지 돌면서 높이 이하인 경우를 0으로 변경 후 bfs처리
		for(int i = 1; i <= max; i++) {
			visited = new boolean[N][N]; // visited배열 초기화
			q = new LinkedList<>(); // 큐 생성
			cnt = 0; // 각 높이에서의 영역 수 초기화
			// 높이 이하인 경우를 0으로 변경
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(data[j][k] <= i)
						data[j][k] = 0;
				}
			}
			// bfs 처리
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(data[j][k] != 0 && !visited[j][k]) {
						visited[j][k] = true;
						q.offer(new Nodes(j,k));
						cnt++;
						bfs();
					}
				}
			}
			// 각 높이에서의 영역 수 가 최대 영역 수보다 크면 변경
			answer = (answer < cnt)?cnt:answer;
		}
		System.out.println(answer);
	}
	private static void bfs() {
		int nx, ny;
		Nodes n;
		// 큐가 비지 않으면
		while(!q.isEmpty()) {
			n = q.poll();
			// 4방 탐색
			for(int i = 0; i < 4; i++) {
				nx = n.x + dx[i];
				ny = n.y + dy[i];
				// 범위 이내면
				if(0<=nx && nx<N && 0<=ny && ny<N) {
					// 잠기지 않았고 방문한 적 없다면
					// 방문 처리하고 큐에 삽입
					if(data[nx][ny] != 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Nodes(nx, ny));
					}
				}
			}
		}
	}
}
// 좌표를 저장하기 위한 클래스
class Nodes{
	int x,y;
	public Nodes(int x, int y){
		this.x = x;
		this.y = y;
	}
}