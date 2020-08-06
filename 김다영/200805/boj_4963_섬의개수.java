package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4963_섬의개수 {
	static int[][] map;
	static int[] dx = {-1,0,1,0,-1,1,1,-1}; // 상 우 하 좌 상우 하우 하좌 상좌
	static int[] dy = {0,1,0,-1,1,1,-1,-1};
	static Queue<Land> q;
	static int h,w;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cnt;
		while(true) {
			q = new LinkedList<>();
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken().trim());
			h = Integer.parseInt(st.nextToken().trim());
			if(w == 0 && h == 0)
				break;
			map = new int[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			}
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1) {
						q.add(new Land(i,j));
						map[i][j] = 0;
						bfs();
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Land tmp;
		int x,y,nx,ny;
		while(!q.isEmpty()) {
			tmp = q.poll();
			x = tmp.x;
			y = tmp.y;
			for(int i = 0; i < 8; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if(0 <= nx && nx < h && 0 <= ny && ny <w) {
					if(map[nx][ny] == 1) {
						q.add(new Land(nx,ny));
						map[nx][ny] = 0;
					}
				}
			}
		}
		
	}

}
class Land{
	int x, y;
	public Land(int x, int y) {
		this.x = x;
		this.y = y;
	}
}