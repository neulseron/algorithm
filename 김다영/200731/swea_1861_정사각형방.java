package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1861_정사각형방 {
	
	static int N, roomNum; // 방번호
	static int[] dx = {-1, 1, 0 ,0}; // 상하좌우 
	static int[] dy = {0, 0, -1, 1};
	static int max; // 현재까지 최대 이동 수
	static int[][] data;
	static int[][] mval;
	static int sx, sy;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine().trim());
			data = new int[N][N];
			mval = new int[N][N];
			max = 1;
			roomNum = Integer.MAX_VALUE;
			// 데이터 입력
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					data[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			}
			// 풀이
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sx = i;
					sy = j;
					Solve(i,j,1);
				}
			}
			sb.append(roomNum).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static void Solve(int i, int j, int cnt) {
		if(mval[i][j] != 0) {
			if(max < cnt+mval[i][j]-1) {
				max = cnt+mval[i][j]-1;
				roomNum = data[sx][sy];
			}else if(max == cnt) {
				if(roomNum > data[sx][sy])
					roomNum = data[sx][sy];
			}
			mval[sx][sy] = cnt+mval[i][j] - 1;
			return;
		}
		int ni,nj;
		boolean check = false;
		for(int d = 0; d < 4; d++) {
			ni = i + dx[d];
			nj = j + dy[d];
			if(isIn(ni, nj)) {
				if(data[i][j] == (data[ni][nj] - 1)) {
					Solve(ni, nj, cnt + 1);
					check = true;
				}
			}
		}
		if(!check) {
			if(max < cnt) {
				max = cnt;
				roomNum = data[sx][sy];
			}else if(max == cnt) {
				if(roomNum > data[sx][sy])
					roomNum = data[sx][sy];
			}
			mval[sx][sy] = cnt;
		}
	}

	private static boolean isIn(int ni, int nj) {
		if(0<= ni && ni < N && 0 <= nj && nj < N) {
			return true;
		}
		return false;
	}
}
