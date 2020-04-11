import java.io.FileInputStream;
import java.util.Scanner;

public class CardGame_9778 {

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_9778.txt"));
		
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		int N, value, tmp, min, j, cnt;
		
		for(int i = 1; i <= TC; i++)
		{
			int num_cnt[] = new int[12];
			N = scan.nextInt();
			value = 0;
			cnt = 0;
			for(j = 0; j < N; j++)
			{
				tmp = scan.nextInt();
				value += tmp;
				num_cnt[tmp]++;
			}
			min = 21 - value + 1;
			for(j = min; j < 12; j++)
			{
				if(j == 10)
					cnt += (16 - num_cnt[j]);
				else
					cnt += (4 - num_cnt[j]);
			}
			if(cnt >=  (52 - N - cnt))
				System.out.println("#" + i + " STOP");
			else
				System.out.println("#" + i + " GAZUA");
		}
	}
}
