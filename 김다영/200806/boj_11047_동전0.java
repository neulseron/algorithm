package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11047_동전0 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken().trim());
		int K = Integer.parseInt(st.nextToken().trim());
		int[] coin = new int[N];
		int max_index = 0; // K보다 작은 최대 가치 번호
		int cnt = 0; // 필요한 동전 개수
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine().trim());
			if(coin[i] <= K)
				max_index = i;
		}
		for(int i = max_index; i >= 0; i--) {
			if(coin[i] <= K) {
				cnt += K/coin[i];
				K %= coin[i];
			}
		}
		System.out.println(cnt);
	}
}