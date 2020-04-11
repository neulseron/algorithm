import java.io.FileInputStream;
import java.util.Scanner;

public class snail_1954 {

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input_1954.txt"));
		
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		int N = 0;
		for(int i = 1; i <= TC; i++)
		{
			N = scan.nextInt();
			int[][] arr = new int[N][N];
			int j = 0, k = 0;
			for(j = 1; j <= N; j++)
			{
				arr[0][j-1] = j;
			}
			int cnt = 1; // plus, minus가 2번씩 반복되는지 확인
			int p_m = 1; // 1이면 +, 0이면 -
			int x = 0;
			int y = N - 1;
			int number = N + 1;
			for(j = N - 1; j >= 1; j--)
			{
				for(int s = 0; s<2; s++)
				{
					if(cnt == 2) // +, - 변경
					{
						if(p_m == 1)
							p_m = 0;
						else
							p_m = 1;
						cnt = 0;
					}
					for(k = 1; k <= j; k++)
					{
						if(p_m == 1)
						{
							if(cnt == 0)
								arr[x][y + k] = number;
							else
								arr[x + k][y] = number;
						}
						else
						{
							if(cnt == 0)
								arr[x][y - k] = number;
							else
								arr[x - k][y] = number;
						}
						number++;
					}
					if(p_m == 1)
					{
						if(cnt == 0)
							y += j;
						else
							x += j;
					}
					else
					{
						if(cnt == 0)
							y -= j;
						else
							x -= j;
					}
					cnt++;
				}
			}
			System.out.println("#"+i);
			for(j = 0; j < N; j++)
			{
				for(k = 0; k < N; k++)
					System.out.print(arr[j][k] + " ");
				System.out.println("");
			}
		}
	}
}
