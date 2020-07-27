package programming.baekjoon;
import java.util.Scanner;

public class scale_2920 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String asc = "1 2 3 4 5 6 7 8";
		String desc = "8 7 6 5 4 3 2 1";
		
		String str = scan.nextLine();
		if(str.equals(asc))
			System.out.println("ascending");
		else if(str.contentEquals(desc))
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
