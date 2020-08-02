package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class boj_3190_뱀_1 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] visited = new int[N][N];
		int time = 0; // 시간
		int[] dx = {-1,0,1,0};// 상 우 하 좌
		int[] dy = {0,1,0,-1};
		
		// 사과 데이터 : visited에 2로 저장
		int appleCnt = Integer.parseInt(br.readLine());
		for(int i = 0; i < appleCnt; i++) {
			st = new StringTokenizer(br.readLine());
			visited[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
		}
		
		// 방향 전환 데이터
		int L = Integer.parseInt(br.readLine());
		int[][] direction = new int[L][2];
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			direction[i][0] = Integer.parseInt(st.nextToken().trim());
			direction[i][1] = st.nextToken().charAt(0);
		}
		
		// 방향 전환 데이터의 index
		int d_idx = 0;
		// 방향 인덱스
		int dir = 1; // 시작 = 오른쪽
		
		// 뱀 좌표
		ArrayList<Node> snake = new ArrayList<>();
		int sx = 0, sy = 0;
		snake.add(new Node(sx, sy));
		// 뱀이 위치하면 1로 저장
		visited[sx][sy] = 1;
		
		while(true) {
			++time;
			sx += dx[dir];
			sy += dy[dir];
			// 범위를 벗어나면 break
			if(sx < 0 || sy < 0 || sx >= N || sy >= N)
				break;
			
			// 뱀의 몸과 만나면 break
			if(visited[sx][sy] == 1)
				break;
			
			snake.add(new Node(sx, sy));
			// 사과 확인
			if(visited[sx][sy] != 2){
				visited[snake.get(0).x][snake.get(0).y] = 0;
				snake.remove(0);
			}
			visited[sx][sy] = 1;
			
			// 방향 전환
			if(d_idx < L && time == direction[d_idx][0]) {
				if((char)direction[d_idx][1] == 'D') { // 오른쪽 회전
					dir = (dir + 1 == 4)?0:dir+1;
				}else { // 왼쪽 회전
					dir = (dir-1<0)?3:dir-1;
				}
				++d_idx;
			}
		}
		System.out.println(time);
	}
}
class Node{
	int x, y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}