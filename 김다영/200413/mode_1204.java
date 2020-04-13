import java.io.FileInputStream;
import java.util.Collections;
import java.util.Scanner;

public class mode_1204 {

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_1204.txt"));
		
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		int TC_num, max, answer = 0;
		int i, j;
		for(i = 1; i <= TC; i++)
		{
			int[] cnt = new int[101];
			TC_num = scan.nextInt();
			max = 0;
			for(j = 0; j < 1000; j++)
				cnt[scan.nextInt()]++;
			for(j = 0; j <= 100; j++)
			{
				if(max <= cnt[j])
				{
					max = cnt[j];
					answer = j;
				}
			}
			System.out.println("#" + TC_num + " " + answer);
		}
	}
}
