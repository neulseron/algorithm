import java.io.FileInputStream;
import java.util.Scanner;
public class Swimming_Pool_1952 {
	static int[] min_prices;
	static int[] prices;
	static int[] accumulated_sum;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1952.txt"));
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		int[] plan = new int[12];
		prices = new int[4];
		accumulated_sum = new int[12];
		int j;
		int min_days, answer;
		for(int i = 1; i <= TC; i++)
		{
			min_prices = new int[12];
			for(j = 0; j < 4; j++)
				prices[j] = scan.nextInt();
			for(j = 0; j < 12; j++)
				plan[j] = scan.nextInt();
			
			min_days = (int)Math.ceil(prices[1] / prices[0]);
			for(j = 0; j < 12; j++)
			{
				if(plan[j] == 0)
					min_prices[j] = 0;
				if(plan[j] > min_days)
					min_prices[j] = prices[1];
				else
					min_prices[j] = (prices[0] * plan[j]);
			}
			price_cal();
			answer = Math.min(accumulated_sum[11], prices[3]);
			System.out.println("#" + i + " " + answer);
		}
	}

	public static void price_cal()
	{
		int i;
		accumulated_sum[0] = min_prices[0];
		for(i = 1; i < 3; i++)
			accumulated_sum[i] = accumulated_sum[i - 1] + min_prices[i];
		accumulated_sum[2] = Math.min(accumulated_sum[2], prices[2]);
		for(i = 3; i < 12; i++)
		{
			accumulated_sum[i] = accumulated_sum[i - 1] + min_prices[i];
			accumulated_sum[i] = Math.min(accumulated_sum[i] , prices[2] + accumulated_sum[i - 3]);
		}
	}
}