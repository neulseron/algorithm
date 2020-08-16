package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1461_도서관 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken().trim());
		int M = Integer.parseInt(st.nextToken().trim());
		long answer = 0;
		int input;
		// 양수 음수 모두 내림차순 정렬
		PriorityQueue<Integer> minus = new PriorityQueue<>((a,b)->b-a);
		PriorityQueue<Integer> plus = new PriorityQueue<>((a,b)->b-a);
		st = new StringTokenizer(br.readLine());
		// 데이터 입력
		for(int i = 0; i < N; i++) {
			input = (Integer.parseInt(st.nextToken().trim()));
			if(input < 0)
				minus.offer(-input); // 양수로 바꿔서 저장
			else
				plus.offer(input);
		}
		// 각 큐에서 최댓값 찾기
		int m_max = minus.isEmpty()?0:minus.peek();
		int p_max = plus.isEmpty()?0:plus.peek();
		// 둘 중 큰 값을 answer에서 빼기
		if(m_max > p_max)
			answer -= m_max;
		else
			answer -= p_max;
		// 큐가 빌 때까지 M개의 책 중 가장 큰 값 *2 더하기 반복
		while(!minus.isEmpty()) {
			answer += minus.poll()*2;
			for(int i = 1; i < M; i++) {
				if(minus.isEmpty())
					break;
				minus.poll();
			}
		}
		
		while(!plus.isEmpty()) {
			answer += plus.poll()*2;
			for(int i = 1; i < M; i++) {
				if(plus.isEmpty())
					break;
				plus.poll();
			}
		}
		System.out.println(answer);
	}
}