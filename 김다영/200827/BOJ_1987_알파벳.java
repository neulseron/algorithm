package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {

	static boolean[] visited;
	static char[][] data;
	static int[] dr = {-1,0,1,0}; // 상우하좌
	static int[] dc = {0,1,0,-1};
	static int R,C,cnt,max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new char[R][];
		visited = new boolean[26];
		for(int i = 0; i < R; i++) {
			data[i] = br.readLine().toCharArray();
		}
		cnt = 1;
		visited[data[0][0]-65] = true;
		search(0,0);
		System.out.println(max);
	}
	private static void search(int r, int c) {
		int nr, nc, tmp;
		for(int d = 0; d < 4; d ++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(!isIn(nr,nc) || visited[data[nr][nc]-65])
				continue;
			tmp = data[nr][nc]-65;
			cnt++;
			visited[tmp] = true;
			search(nr,nc);
			visited[tmp] = false;
			cnt--;
		}
		max = max < cnt ? cnt : max;
	}
	// 범위 체크
	private static boolean isIn(int r, int c) {
		if(0<=r && r<R && 0<=c && c<C)
			return true;
		return false;
	}
}