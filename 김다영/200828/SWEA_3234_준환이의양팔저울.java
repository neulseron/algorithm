package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {

	static int N, answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			int[] input = new int[N];
			boolean[] visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			// 데이터 입력
			for(int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken().trim());
			}
			perm(0, 0, 0, input, visited);
			System.out.println("#" + tc + " " + answer);
		}
	}
	// cnt : 사용한 추의 개수, left : 왼쪽 무게, right : 오른쪽 무게, input : 무게 배열, visited : 방문 배열
	private static void perm(int cnt, int left, int right, int[] input, boolean[] visited) {
		if(cnt == N-1) {
			answer++;
			// 아직 방문하지 않은 한 곳에 대해 right+무게가 left보다 작거나 같은 경우만 answer+1
			for(int i = 0; i < N; i++) {
				if(!visited[i] && left >= right+input[i]) {
					answer++;
					break;
				}
			}
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			// 왼쪽은 항상 가능
			perm(cnt+1, left + input[i], right, input, visited);
			// 오른쪽은 더한 무게가 왼쪽보다 작거나 같으면 진행
			if(left >= right + input[i])
				perm(cnt+1, left, right + input[i], input, visited);
			visited[i] = false;
		}
	}
}