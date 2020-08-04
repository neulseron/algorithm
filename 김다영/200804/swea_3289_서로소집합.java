package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3289_서로소집합 {
	static int[] parents;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n, m, a, b, z_o, f_a, f_b;
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken().trim());
			m = Integer.parseInt(st.nextToken().trim());
			parents = new int[n + 1];
			// 부모 배열 초기화
			for(int i = 1; i <= n; i++)
				parents[i] = i;
			// m개의 연산 수행
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				z_o = Integer.parseInt(st.nextToken().trim());
				a = Integer.parseInt(st.nextToken().trim());
				b = Integer.parseInt(st.nextToken().trim());
				f_a = find(a);
				f_b = find(b);
				// 0 : 합집합, 1 : 같은 집합 포함 여부
				if(z_o == 0) {
					// 같은 집합에 포함되어있지 않으면
					if(f_a != f_b) {
						parents[f_b] = f_a;
					}
				}else if(z_o == 1){
					if(f_a == f_b) {
						sb.append("1");
					}else
						sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	// 루트 찾기
	private static int find(int a) {
		if(parents[a] == a)
			return a;
		else
			return parents[a] = find(parents[a]);
	}

}
