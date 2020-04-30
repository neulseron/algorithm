import java.io.FileInputStream;
import java.util.Scanner;
public class Make_Number_4008 {
	static int[] operator; // '+', '-', '*', '/'
	static int[] number;
	static int min;
	static int max;
	static int N;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_4008.txt"));
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		operator = new int[4];
		int j;
		for(int i = 1; i <= TC; i++)
		{
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			N = scan.nextInt();
			number = new int[N];
			for(j = 0; j < 4; j++)
				operator[j] = scan.nextInt();
			for(j = 0; j < N; j++)
				number[j] = scan.nextInt();
			
			Solve(number[0], 1);
			System.out.println("#" + i + " " + (max - min));
		}
	}
	
	public static void Solve(int num, int idx)
	{
		if(idx == N)
		{
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		else
		{
			if(operator[0] != 0) // '+'
			{
				operator[0]--;
				Solve(num + number[idx], idx + 1);
				operator[0]++;
			}
			if(operator[1] != 0) // '-'
			{
				operator[1]--;
				Solve(num - number[idx], idx + 1);
				operator[1]++;
			}
			if(operator[2] != 0) // '*'
			{
				operator[2]--;
				Solve(num * number[idx], idx + 1);
				operator[2]++;
			}
			if(operator[3] != 0) // '/'
			{
				operator[3]--;
				Solve(num / number[idx], idx + 1);
				operator[3]++;
			}
		}
	}
}