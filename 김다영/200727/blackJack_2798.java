package programming.baekjoon;
import java.util.Scanner;

public class blackJack_2798 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] arr = new int[N];
		int i, j, k; // index를 위한 변수
		int a, b, c; //3장의 카드 숫자를 저장할 변수
		int sum; // 3장의 카드 숫자의 합
		int near = 0; // M과 가장 가까운 합
		// N개의 카드 값을 저장
		for(i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		// 카드 3장 숫자의 합을 계산
		Solve:
			for(i = 0; i < N - 2; i++) {
			a = arr[i];
			for(j = i + 1; j < N - 1; j++) {
				b = arr[j];
				for(k = j + 1; k < N; k++) {
					c = arr[k];
					sum = a + b + c;
					if(M == sum) { // 기준 M과 동일하면 break
						near = sum;
						break Solve;
					}
					else if(M > sum) { // M보다 큰 경우는 고려 X. near과 sum 중에 M과 더 가까운 값으로 저장
						near = (M - sum) < (M - near) ? sum : near;
					}
				}
			}
		}
		System.out.println(near);
	}
}
