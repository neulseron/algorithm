import java.io.FileInputStream;
import java.util.Scanner;

public class seokchan_9317 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_9317.txt"));
		
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt(); // 테스트케이스
		int N = 0;
		int cnt = 0;
		String str_1;
		String str_2;
		for(int i = 1; i <= TC; i++)
		{
			N = scan.nextInt(); // 문자열 길이
			str_1 = scan.next(); // 기준 문자열
			str_2 = scan.next(); // 받아쓴 문자열
			cnt = 0;
			for(int j = 0;j < N;j++)
			{
				if(str_1.charAt(j)==str_2.charAt(j))
					cnt++;
			}
			System.out.println("#" + i + " " + cnt);
		}
	}

}
