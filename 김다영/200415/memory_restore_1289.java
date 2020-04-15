import java.io.FileInputStream;
import java.util.Scanner;

public class memory_restore_1289 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1289.txt"));
		
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		String s;
		int answer = 0;
		int i, j = 0 ;
		for(i = 1; i <= TC; i++)
		{
			answer = 0;
			s = scan.next();
			if(s.charAt(0) == '1')
				answer++;
			
			for(j = 1; j < s.length(); j++)
			{
				if(s.charAt(j - 1) == s.charAt(j))
					continue;
				else
					answer++;
			}
			System.out.println("#" + i + " " + answer);
		}
		scan.close();
	}
}
