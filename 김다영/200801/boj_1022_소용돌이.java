package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1022_소용돌이 {
	
	// 전체 배열의 크기 지정
	static int maxCnt, w, h; // data의 총 수. 가로. 세로
	static int[][] data;
	static int[] xy = new int[4]; // r1,c1,r2,c2
	static int[] dx = {0, -1, 0, 1}; // 우 상 좌 하
	static int[] dy = {1, 0, -1, 0};
	static int cnt; // 몇 칸 이동할 것인가
	static int print_size; // 출력때 일치해야 할 출력 크기
	static int real_max; // 실제 출력할 데이터 중 가장 큰 값
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// r1,r2,c1,c2데이터 입력
		for(int i = 0; i < 4; i++) {
			xy[i] = Integer.parseInt(st.nextToken());
		}
		// 최종 가로, 세로길이
		w = xy[3]-xy[1] + 1;
		h = xy[2]-xy[0] + 1;
		
		maxCnt = h*w; // 데이터의 총 개수
		data = new int[h][w];
		
		// 소용돌이 데이터 입력 함수 호출
		input();
		print_size = Integer.toString(real_max).length();
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				System.out.printf("%"+print_size+"d ", data[i][j]);
			}
			System.out.println();
		}
	}

	private static void input() {
		int x = 0, y = 0;
		int dataCnt = 0; // 배열에 입력된 데이터 수
		int curNum = 1; // 현재 입력할  수
		if(xy[0] <= x && x <= xy[2] && xy[1] <= y && y <= xy[3]) {
			data[x-xy[0]][y-xy[1]] = curNum;
			++dataCnt;
		}
		++curNum;
		while(dataCnt != maxCnt) {
			// 우 상 좌 하
			for(int j = 0; j < 4; j++) {
				// 우, 좌에서 이동횟수 증가
				if(j % 2 == 0) {
					++cnt;
				}
				// 각 방향의 이동 수만큼 진행
				for(int k = 0; k < cnt; k++) {
					x += dx[j];
					y += dy[j];
					if(xy[0] <= x && x <= xy[2] && xy[1] <= y && y <= xy[3]) {
						real_max = curNum;
						data[x - xy[0]][y - xy[1]] = curNum;
						++dataCnt;
					}
					++curNum;
				}
			}
		}
	}
}
