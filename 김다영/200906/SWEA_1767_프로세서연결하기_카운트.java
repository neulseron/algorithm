package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기_카운트 {
	static int N, min, max, totalCnt;
	static int[][] data;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static ArrayList<int[]> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			data = new int[N][N];
			min = Integer.MAX_VALUE;
			list = new ArrayList<>();
			max = 0;
			totalCnt = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					data[i][j] = Integer.parseInt(st.nextToken().trim());
					if((i == 0 || j == 0 || i == N-1 || j == N-1) && data[i][j] == 1) continue;
					if(data[i][j] == 1) {
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			} // end input
			go(0,0,0);
			System.out.println("#" + tc + " " + min);
		} // end TC
	}
	private static void go(int index, int cCnt, int lCnt) {
		
		// 현재까지 연결된 코어수 + 앞으로 처리해야 할 남은 코어수 : 기대할 수 있는 최대 코어수
		// 기대할 수 있는 최대 코어수가 임시해보다 작다면 진행이 의미 없음
		if(cCnt + totalCnt - index < max) return; // 가지치기
		
		if(index == totalCnt) {
			if(max < cCnt) {
				max = cCnt;
				min = lCnt;
			}else if(max == cCnt) { // 코어수가 같다면
				if(min > lCnt) {
					min = lCnt;
				}
			}
			return;
		}
		
		int[] rc = list.get(index);
		int r = rc[0];
		int c = rc[1];
		int len;
		// 해당 코어 선택
		// 4방향의 직선으로 전선 높아보는 시도
		for(int d = 0; d < 4; d++) {
			// 해당 방향으로 전선 놓는게 가능한지 체크
			if(isAvailable(r,c,d)) {
				// 가능하다면 전선 놓기 : 판에 2로 셋팅
				len = setting(r,c,d,2);
				// 다음 코어 넘어가기
				go(index+1, cCnt+1, lCnt + len);
				// 전선 회수 : 2를 0으로 셋팅
				setting(r,c,d,0);
			}
			
		}
		
		// 해당 코어 비선택
		// 아무런 전선도 놓지 않고 다음코어로 넘어가기
		go(index+1, cCnt, lCnt);
	}

	// 현 코어의 위치에서 해당 장향으로 전선을 놓거나(2) 지우는(0) 셋팅
	private static int setting(int r, int c, int d, int type) {
		int nr = r, nc = c, result = 0;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			data[nr][nc] = type;
			result++;
		}
		return result;
	}
	// 현 코어의 위치에서 해당 방향으로 전선을 놓는게 가능한지 체크
	private static boolean isAvailable(int r, int c, int d) {
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			if(data[nr][nc] >= 1) return false; // 1 : 코어, 2 : 전선
		}
		return true;
	}
}