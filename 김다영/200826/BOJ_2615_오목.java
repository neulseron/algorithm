package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {

	static int[][] data;
	static int[] dx = {0,1,1,-1}; // 우 하 우하 상우
	static int[] dy = {1,0,1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		data = new int[19][19];
		int tmp; // 임시 저장 변수
		for(int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				data[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}// end for
		int answer = -1;
		Solve:
		for(int y = 0; y < 19; y++) {
			for(int x = 0; x < 19; x++) {
				for(int d = 0; d < 4; d++) {
					tmp = data[x][y];
					if(tmp == 0)
						continue;
					if(isIn(x-dx[d], y-dy[d]) && data[x-dx[d]][y-dy[d]]==tmp)
						continue;
					int ny = y, nx = x, cnt = 0;
					for(int k = 0; k < 5; k++) {
						ny += dy[d];
						nx += dx[d];
						if(!isIn(nx,ny))
							break;
						if(data[nx][ny] != data[x][y])
							break;
						cnt++;
					}
					if(cnt == 4) {
						answer = data[x][y];
						System.out.println(data[x][y]);
						System.out.println((x+1) + " " + (y+1));
						break Solve;
					}
				}
			}
		}
		if(answer == -1) {
			System.out.println(0);
		}
	}
	private static boolean isIn(int x, int y) {
		return (0 <= x && x < 19 && 0 <= y && y < 19);
	}
}