package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_1873_상호의배틀필드 {
	private static int[]dx = {-1,1,0,0}; // 상하좌우
	private static int[]dy = {0,0,-1,1};
	private static int[] start = new int[2]; // 전차의 위치
	private static int dir = -1; // 0 : U, 1 : D, 2: L, 3 : R. 전차가 바라보는 방향
	private static char[] dir_char = {'^','v','<','>'};
	private static char[][] arr; // 격자판 배열
	private static int H,W,N;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str;
		String[] tmp;
		char ch; // 사용자 입력
		boolean S_check = false; // input이 S인지 확인
		// 테스트케이스 시작
		for(int tc = 1; tc <= T; tc++) {
			tmp = br.readLine().split(" ");
			H = Integer.parseInt(tmp[0]);
			W = Integer.parseInt(tmp[1]);
			arr = new char[H][W];
			dir = -1;
			// 격자판 입력
			for(int i = 0; i < H; i++) {
				str = br.readLine();
				for(int j = 0; j < W; j++) {
					arr[i][j] = str.charAt(j);
					// 전차의 시작 위치와 방향 저장
					switch (arr[i][j]) {
					case '^': // 상
						dir = 0;
						start[0] = i;
						start[1] = j;
						break;
					case 'v': // 하
						dir = 1;
						start[0] = i;
						start[1] = j;
						break;
					case '<': // 좌
						dir = 2;
						start[0] = i;
						start[1] = j;
						break;
					case '>': // 우
						dir = 3;
						start[0] = i;
						start[1] = j;
						break;
					default:
						break;
					}
				}
			}
			// input count
			N = Integer.parseInt(br.readLine());
			str = br.readLine();
			// input길이만큼 반복
			for(int i = 0; i < N; i++) {
				ch = str.charAt(i);
				S_check = false;
				switch (ch) {
				case 'U': // 상
					dir = 0;
					move();
					break;
				case 'D': // 하
					dir = 1;
					move();
					break;
				case 'L': // 좌
					dir = 2;
					move();
					break;
				case 'R': // 우
					dir = 3;
					move();
					break;
				case 'S':
					S_check = true;
					break;
				}
				// S라면
				if(S_check) {
					int nx = start[0];
					int ny = start[1];
					while(true) {
						nx += dx[dir];
						ny += dy[dir];
						if(isIn(nx, ny, H, W)) { // 범위 안이라면
							if(arr[nx][ny] == '#')//강철과 만나면 break
								break;
							else if(arr[nx][ny] == '*') {// 벽돌과 만나면 평지로 바꾸고 break
								arr[nx][ny] = '.';
								break;
							}
						}
						else
							break;
					}
				}
			}
			System.out.print("#" + tc + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}
	// U, D, L, R를 만났을 때 평지로 이동하는지 방향만 바꾸는지 check
	private static void move() {
		arr[start[0]][start[1]] = dir_char[dir];
		int nx = start[0] + dx[dir];
		int ny = start[1] + dy[dir];
		if(isIn(nx, ny, H, W)) {
			if(arr[nx][ny] == '.') {
				arr[start[0]][start[1]] = '.';
				start[0] = nx;
				start[1] = ny;
				arr[nx][ny] = dir_char[dir];
			}
		}
	}
	// 범위 체크
	private static boolean isIn(int i, int j, int h, int w) {
		if(0 <= i && i < h && 0 <= j && j < w) {
			return true;
		}
		return false;
	}
}
