package programming.baekjoon.no18000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18513_샘터 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 버퍼 생성
		StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 입력데이터를 구분
		int N = Integer.parseInt(st.nextToken().trim()); // 치킨집 개수 : N
		int K = Integer.parseInt(st.nextToken().trim()); // 집의 수 : K
		int change = 100000000; // index 변경을 위해 (음수처리를 위함)
		long distance = 0; // 총 치킨 지수
		int cnt = 1; // 현재 집에서의 치킨 지수
		int x, nx, size; // 임시저장 변수
		boolean[] visited = new boolean[200000001]; // 방문 배열 최대 크기로 선언
		int[] chicken = new int[N]; // 치킨집 index 저장
		int[] dc = {-1, 1};
		Queue<Info> q = new LinkedList<>();
		Info tmp;
		st = new StringTokenizer(br.readLine()); // 입력데이터를 공백 기준으로 구분
		for(int i = 0; i < N; i++) { // 치킨집 위치 저장
			chicken[i] = Integer.parseInt(st.nextToken().trim()) + change; // 음수를 처리하기 위해 최소를 0으로 맞추는 작업
			visited[chicken[i]] = true; // 치킨집 방문처리
			q.offer(new Info(chicken[i],cnt));
		}
		// 모든 집을 설치하면 break (K가 0이 된 순간)
		BFS:
			while(!q.isEmpty()) {
				size = q.size();
				for(int i = 0; i < size; i++) {
					tmp = q.poll();
					x = tmp.x;
					for(int d = 0; d < 2; d++) {
						nx = x + dc[d]; // 왼쪽,오른쪽으로 cnt만큼 떨어진 곳 저장
						if(isIn(nx) && !visited[nx]) { // tmp가 유효한 위치인지, 방문한 적이 없는지 확인
							visited[nx] = true; // 방문처리
							if(K-- != 0) {
								distance += tmp.cnt;
								q.offer(new Info(nx, cnt+1));
							}else {
								break BFS;
							}
						}
					}
				}
				cnt++;
			}
		System.out.println(distance); // 총 치킨 지수 출력
	}
	private static boolean isIn(int i) { // 범위 체크
		if(0<=i && i<=200000000) return true; // 유효한 범위 내에 있다면 true 리턴;
		return false; // 아니라면 false 리턴
	}
	static class Info{
		int x, cnt;
		public Info(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
}