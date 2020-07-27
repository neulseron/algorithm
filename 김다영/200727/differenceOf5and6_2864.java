package programming.baekjoon;
import java.util.Scanner;

public class differenceOf5and6_2864 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		String B = scan.next();
		
		int min_A = Integer.parseInt(A.replaceAll("6", "5"));
		int max_A = Integer.parseInt(A.replaceAll("5", "6"));
		int min_B = Integer.parseInt(B.replaceAll("6", "5"));
		int max_B = Integer.parseInt(B.replaceAll("5", "6"));
		
		System.out.println((min_A + min_B) + " " + (max_A + max_B));
	}

}
