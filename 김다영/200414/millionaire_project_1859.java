import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class millionaire_project_1859 {

	public static void main(String[] args) throws Exception
	{
		System.setIn(new FileInputStream("res/input_1859.txt"));
		Scanner scan = new Scanner(System.in);
		int test_case = scan.nextInt(); // 총 테스트케이스 수
		int N = 0, max = 0, max_index = -1; // 연속 N일
		long answer = 0;
		int i, j, k;
		for(i = 1; i <= test_case; i++)
		{
			N = scan.nextInt();
			ArrayList<Integer> prices = new ArrayList<Integer>();
			for(j = 0; j < N; j++)
			{
				prices.add(scan.nextInt());
			}
			answer = 0; // 총 수입
			max = 0; 
			max_index = -1;
			for(j = 0; j < N; j++)
			{
				if(max_index >= j)
					;
				else
				{
					max = 0;
					for(k = j; k < N; k++)
					{
						if(max < prices.get(k))
						{
							max = prices.get(k);
							max_index = k;
						}
					}
				}
				answer += (max - prices.get(j));
			}
			System.out.println("#" + i + " " + answer);
		}
		scan.close();
	}
}
