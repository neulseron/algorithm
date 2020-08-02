package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1158_요세푸스문제 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> person = new ArrayList<>();
		
		// 실제 이동횟수는 K-1
		K -= 1;
		// 현재 index
		int idx = 0;
		
		// 데이터 입력
		for(int i = 1; i <= N; i++)
			person.add(i);
		
        // 한 사람만 남을 때까지
		while(person.size() != 1) {
            // 삭제 후 사이즈가 index와 동일한 경우 index = 0으로 초기화
			if(idx == person.size()) {
				idx = 0;
			}
			if(idx + K >= person.size()) {// arraylist의 길이보다 이동 후 인덱스가 크면
				idx = (idx + K) % person.size();
			}
			else {
				idx += K;
			}
			sb.append(person.get(idx)).append(", ");
			person.remove(idx);
		}
		sb.append(person.get(0)).append(">");
		System.out.println(sb);
	}
}