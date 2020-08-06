package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2667_단지번호붙이기 {
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> arr; // 단지 크기 저장
	static int[] dx = {-1,0,1,0}; // 상 우 하 좌
	static int[] dy = {0,1,0,-1};
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		visited = new boolean[N][N];
		arr = new ArrayList<>();
		String str;
		// 입력
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		// 처리
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(new Complex(i,j));
				}
			}
		}
		arr.sort(null);
		int size = arr.size();
		System.out.println(size);
		for(int i = 0; i < size; i++) {
			System.out.println(arr.get(i));
		}
	}

	private static void bfs(Complex node) {
		Queue<Complex> q = new LinkedList<>();
		q.add(node);
		visited[node.x][node.y] = true;
		Complex tmp;
		int x,y,nx,ny,cnt = 1;
		while(!q.isEmpty()) {
			tmp = q.poll();
			x = tmp.x;
			y = tmp.y;
			for(int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						q.add(new Complex(nx, ny));
						visited[nx][ny] = true;
						cnt++;
					}
				}
			}
		}
		arr.add(cnt);
	}
}

class Complex{
	int x, y;
	public Complex(int x, int y) {
		this.x = x;
		this.y = y;
	}
}