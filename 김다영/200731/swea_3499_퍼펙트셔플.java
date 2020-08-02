package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class swea_3499_퍼펙트셔플 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N;
		String[] arr1, arr2;
		
		// 테스트 케이스 시작
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			N = Integer.parseInt(br.readLine());
			int len_1, len_2; // 첫 번째 덱 길이, 두 번째 덱 길이
			
			// len_2 <= len_1
			len_2 = N/2;
			len_1 = N-len_2;
			arr1 = new String[len_1];
			arr2 = new String[len_2];
			
			st = new StringTokenizer(br.readLine());
			
			// 데이터 입력
			for(int i = 0; i < len_1; i++) {
				arr1[i] = st.nextToken();
			}
			for(int i = 0; i < len_2; i++) {
				arr2[i] = st.nextToken();
			}
			
			// 데이터 출력
			for(int i = 0; i < len_2; i++) {
				sb.append(arr1[i]).append(" ");
				sb.append(arr2[i]).append(" ");
			}
			
			// 홀수라면
			if(len_1 > len_2)
				sb.append(arr1[len_2]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
