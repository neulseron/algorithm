package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697_숨바꼭질 {
	static int N, K, level; // N : 수빈이 위치, K : 동생 위치, level은 최종 시간
	// 같은 위치라면 먼저 도착한 경우가 가장 빠른 경우이기 때문에 방문처리를 하기 위한 변수
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위함
		StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 문자열 분리
		// 구분한 문자열을 숫자로 변형하여 저장
		N = Integer.parseInt(st.nextToken().trim());//수빈이 위치
		K = Integer.parseInt(st.nextToken().trim());//동생 위치
		// bfs시작
		bfs();
		// 결과 출력
		System.out.println(level);
	}
	// 3가지 경우를 고려하면서 가장 빠른 경로 탐색
	private static void bfs() {
		// 경로탐색을 위한 큐 생성
		Queue<Integer> q = new LinkedList<>();
		// 수빈이의 현재 위치 삽입
		q.offer(N);
		// 방문한 위치 방문 처리
		visited[N] = true;
		// size : 큐 사이즈 저장, tmp : 큐에서 꺼낸 값 저장, a : 중간 계산값 저장
		int size, tmp, a;
		// 큐가 빌 때까지
		while(!q.isEmpty()) {
			size = q.size(); // 큐 사이즈 저장
			// 큐 사이즈만큼 반복
			for(int i = 0; i < size; i++) {
				// 큐에서 꺼낸 값 저장
				tmp = q.poll();
				// 큐에서 꺼낸 값이 동생 위치라면 return
				if(tmp == K)
					return;
				// a에 3가지 경우를 담고 범위와 방문 여부 체크
				a = tmp - 1;
				// 범위에 포함되고 방문한 적 없으면 큐에 삽입 & 방문 처리
				if(0<= a && a <= 100000 && !visited[a]) {
					q.offer(a);
					visited[a] = true;
				}
				a = tmp + 1;
				// 범위에 포함되고 방문한 적 없으면 큐에 삽입 & 방문 처리
				if(0<= a && a <= 100000 && !visited[a]) {
					q.offer(a);
					visited[a] = true;
				}
				a = 2 * tmp;
				// 범위에 포함되고 방문한 적 없으면 큐에 삽입 & 방문 처리
				if(0<= a && a <= 100000 && !visited[a]) {
					q.offer(a);
					visited[a] = true;
				}
			}
			// 큐에 들어있던 모든 과정이 끝나면 level 증가
			// 이때의 level은 현재까지 흐른 시간
			++level;
		}
	}
}