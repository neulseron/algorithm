package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13335_트럭 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken().trim());
		int w = Integer.parseInt(st.nextToken().trim());
		int L = Integer.parseInt(st.nextToken().trim());
		int time = 0; // 전체 시간
		int curWeight = 0; // 현재 다리 위 무게
		int[] arr = new int[n]; // 각 트럭 무게
		Queue<Integer> q = new LinkedList<>();
		// 최근 올라간 트럭 번호
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken().trim());
		}
		// n개의 트럭이 모두 다리에 올라올 때까지
		while(idx < n) {
			++time;
			// 다리 위에 트럭 수가 w개면
			if(q.size() == w) {
				curWeight -= q.poll();
			}
			// 다리 위에 트럭이 올라갈 수 있으면
			if(curWeight + arr[idx] <= L) {
				q.offer(arr[idx]);
				curWeight += arr[idx++];	
			}else
				q.offer(0); // 트럭 무게일 수 없고, 위에서 무게를 뺄 때 영향 X
		}
		System.out.println(time + w);
	}
}