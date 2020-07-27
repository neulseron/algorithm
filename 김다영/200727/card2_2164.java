package programming.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class card2_2164 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) { // 1 - N까지의 수를 순서대로 저장
			queue.add(i);
		}
		int tmp;
		while(true) {
			if(queue.size() == 1)
				break;
			queue.remove(); // 맨앞에 있는 요소, 가장 먼저 저장된 요소 제거
			tmp = queue.poll(); // 맨 앞에 있는 요소 반환 후 제거
			queue.add(tmp); // 맨 뒤에 추가
		}
		System.out.println(queue.poll());
	}
}
