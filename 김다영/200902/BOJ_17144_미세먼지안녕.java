package programming.baekjoon.no_17000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	static int R,C,r1, r2;
	static int[][] temp, data;
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken().trim());
		C = Integer.parseInt(st.nextToken().trim());
		int T = Integer.parseInt(st.nextToken().trim());
		data = new int[R][C];
		int answer = 0;
		boolean flag = true;
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				data[i][j] = Integer.parseInt(st.nextToken().trim());
				if(data[i][j] == -1 && flag) {
					r1 = i;
					r2 = i+1;
					flag = false;
				}
			}
		}
		// T초동안 진행
		for(int i = 0; i < T; i++) {
			// 확산 진행
			temp = new int[R][C];
			for(int j = 0; j < R; j++) {
				for(int k = 0; k < C; k++) {
					if(data[j][k] != 0 && data[j][k] != -1)
						spread(j,k);
				}
			}
			// 확산 후 결과 저장
			for(int j = 0; j < R; j++) {
				for(int k = 0; k < C; k++) {
					data[j][k] = temp[j][k];
				}
			}
			data[r1][0] = -1;
			data[r2][0] = -1;
			
			// 공기청정기 동작
			run1();
			run2();
		}
		for(int j = 0; j < R; j++) {
			for(int k = 0; k < C; k++) {
				if(data[j][k] != 0 && data[j][k] != -1)
					answer += data[j][k];
			}
		}
		System.out.println(answer);
	}
	// 확산
	private static void spread(int r, int c) {
		int nr, nc, amount;
		temp[r][c] += data[r][c];
		amount = data[r][c]/5;
		// 4방 탐색
		for(int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(isIn(nr, nc) && data[nr][nc] != -1) {
				temp[nr][nc] += amount;
				temp[r][c] -= amount;
			}
		}
	}
	// 동작
	private static void run1() {
		// 반시계 동작 (r1 활용)
		int tmp1 = data[r1][C-1];
		for(int i = C-1; i > 1; i--)
			data[r1][i] = data[r1][i-1]; // 오른쪽으로 한 칸씩 밀기
		data[r1][1] = 0; // 미세먼지 없는 바람이므로
		
		int tmp2 = data[0][C-1];
		for(int i = 0; i < r1-1; i++)
			data[i][C-1] = data[i+1][C-1];
		data[r1-1][C-1] = tmp1;
		tmp1 = tmp2;
		
		tmp2 = data[0][0];
		for(int i = 0; i < C-2; i++)
			data[0][i] = data[0][i+1];
		data[0][C-2] = tmp1;
		
		for(int i = r1-1; i > 1; i--)
			data[i][0] = data[i-1][0];
		data[1][0] = tmp2;
	}
	
	private static void run2() {
		// 시계 동작 (r2 활용)
		int tmp1 = data[r2][C-1];
		for(int i = C-1; i > 1; i--)
			data[r2][i] = data[r2][i-1]; // 오른쪽으로 한 칸씩 밀기
		data[r2][1] = 0; // 미세먼지 없는 바람이므로
		
		int tmp2 = data[R-1][C-1];
		for(int i = R-1; i > r2+1; i--)
			data[i][C-1] = data[i-1][C-1];
		data[r2+1][C-1] = tmp1;
		tmp1 = tmp2;
		
		tmp2 = data[R-1][0];
		for(int i = 0; i < C-2; i++)
			data[R-1][i] = data[R-1][i+1];
		data[R-1][C-2] = tmp1;
		
		for(int i = r2+1; i < R-2; i++)
			data[i][0] = data[i+1][0];
		data[R-2][0] = tmp2;
	}
	
	private static boolean isIn(int r, int c) {
		if(0<=r && r<R && 0<=c && c<C) return true;
		return false;
	}
}