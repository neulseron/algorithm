package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1026_보물 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int answer = 0, max;
		int[] arr = new int[N];
		ArrayList<Integer> list = new ArrayList<>();
		// A배열 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken().trim());
		// B배열 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken().trim()));
		// A배열 오름차순 정렬
		Arrays.sort(arr);
		for(int i = 0; i < N; i++) {
			// B배열 최댓값 찾기
			max = Collections.max(list);
			// max를 삭제 (index가 아닌 객체로 처리하기 위해 Integer로 처리)
			list.remove((Integer)max);
			// 정답 계산
			answer += arr[i]*max;
		}
		System.out.println(answer);
	}
}