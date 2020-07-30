package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea2001_파리퇴치 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N, M;
		String[] tmp;
		int[][] arr;
		int max = 0; // 최대
		int sum = 0; // 중간 합
		// 테스트케이스 시작
		for(int tc = 1; tc <= T; tc++) {
			max = 0;
			tmp = br.readLine().split(" ");
			N = Integer.parseInt(tmp[0]);
			M = Integer.parseInt(tmp[1]);
			arr = new int[N][N];
			// 데이터 입력
			for(int i = 0; i < N; i++) {
				tmp = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			// 죽은 파리 수 계산
			for(int i = 0; i <= N-M; i++) {
				for(int j = 0; j <= N-M; j++) {
					sum = 0;
					for(int k = 0; k < M; k++) {
						for(int s = 0; s < M; s++) {
							sum += arr[i+k][j+s];
						}
					}
					max = (max<sum)?sum:max;
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}
