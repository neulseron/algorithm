package programming.baekjoon.no_3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {

	static int R,C,cnt;
	static char[][] data;
	static boolean[][] visited;
	static int[] dr = {-1,0,1}; // 상우 우 하우
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken().trim());
		C = Integer.parseInt(st.nextToken().trim());
		data = new char[R][];
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++)
			data[i] = br.readLine().toCharArray();
		visited[0][0] = true;
		for(int i = 0; i < R; i++)
			search(i,0);
		System.out.println(cnt);
	}

	private static boolean search(int r, int c) {
		
		if(c == C-1) {
			cnt++;
			return true;
		}
		int nr, nc = c+1;
		for(int i = 0; i < 3; i++) {
			nr = r + dr[i];
			if(!isIn(nr,nc) || visited[nr][nc] || data[nr][nc] == 'x')
				continue;
			visited[nr][nc] = true;
			if(search(nr,nc))
				return true;
		}
		return false;
	}
	private static boolean isIn(int r, int c) {
		if(0<=r && r<R && 0<=c && c<C)
			return true;
		return false;
	}
}
