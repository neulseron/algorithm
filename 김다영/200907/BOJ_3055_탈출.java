package programming.baekjoon.no_3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055_탈출 {
	static int[] dr = {-1, 0, 1 ,0};
	static int[] dc = {0, 1, 0, -1};
	static int R,C;
	static Point home;
	static Queue<Point> q = new LinkedList<>();
	static char[][] map;
	static Queue<Point> fire = new LinkedList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken().trim());
		C = Integer.parseInt(st.nextToken().trim());
		String str;
		Point start = null;
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'D') home = new Point(i,j);
				if(map[i][j] == 'S') start = new Point(i,j);
				if(map[i][j] == '*') {
					fire.offer(new Point(i,j));
				}
			}
		}
		q.offer(start);
		int answer = bfs();
		if(answer == -1)
			System.out.println("KAKTUS");
//			System.out.println("impossible");
		else
			System.out.println(answer);
	}
	private static int bfs() {
		Point cur;
		int size,fSize, nr, nc, fr, fc, time = 1;
		while(!q.isEmpty()) {
			size = q.size();
			fSize = fire.size();
			for(int i = 0; i < fSize; i++) {
				Point p = fire.poll();
				for(int f = 0; f < 4; f++) {
					fr = p.r + dr[f];
					fc = p.c + dc[f];
					if(!isIn(fr,fc) || map[fr][fc] == 'X' || map[fr][fc] == 'D' || map[fr][fc] == '*') continue;
					fire.offer(new Point(fr,fc));
					map[fr][fc] = '*';
				}
			}
			for(int s = 0; s < size; s++) {
				cur = q.poll();
				for(int d = 0; d < 4; d++) {
					nr = cur.r + dr[d];
					nc = cur.c + dc[d];
					if(nr == home.r && nc == home.c) return time;
					if(!isIn(nr,nc) || map[nr][nc] == '*' || map[nr][nc] == 'X' || map[nr][nc] == 'S') continue;
					q.offer(new Point(nr,nc));
					map[nr][nc] = 'S';
				}
			}

			time++;
		}
		return -1;
	}
	private static boolean isIn(int r, int c) {
		if(0<=r && r<R && 0<=c && c<C) return true;
		return false;
	}
	static class Point{
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}