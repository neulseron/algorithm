import java.io.FileInputStream;
import java.util.Scanner;
public class Sum_Day2_1209 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1209.txt"));
		Scanner scan = new Scanner(System.in);
		int TC, tmp, max;
		int j, k, index_1 = 0, index_2 = 99;
		int [] width_sum;
		int [] height_sum;
		int diagonal_sum_1;
		int diagonal_sum_2;
		for(int i = 1; i <= 10; i++)
		{
			TC = scan.nextInt();
			width_sum = new int[100];
			height_sum = new int[100];
			diagonal_sum_1 = 0;
			diagonal_sum_2 = 0;
			max = 0;
			
			for(j = 0; j < 100; j++)
			{
				for(k = 0; k < 100; k++)
				{
					tmp = scan.nextInt();
					width_sum[j] += tmp;
					height_sum[k] += tmp;
					if(k == index_1)
						diagonal_sum_1 += tmp;
					if(k == index_2)
						diagonal_sum_2 += tmp;
					index_1++;
					index_2--;
				}
				if(max < width_sum[j])
					max = width_sum[j];
			}
			for(j = 0; j < 100; j++)
			{
				if(max < height_sum[j])
					max = height_sum[j];
			}
			if(max < diagonal_sum_1)
				max = diagonal_sum_1;
			if(max < diagonal_sum_2)
				max = diagonal_sum_2;
			System.out.println("#" + TC + " " + max);
			width_sum = null;
			height_sum = null;
		}
	}
}