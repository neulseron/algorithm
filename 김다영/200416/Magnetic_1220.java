import java.io.FileInputStream;
import java.util.Scanner;

public class Magnetic_1220 {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1220.txt"));
		Scanner scan = new Scanner(System.in);
		int i,j,k;
		int width, answer = 0;
		for(i = 1; i <= 10; i++)
		{
			answer = 0;
			width = scan.nextInt();
			int[][] num_arr = new int[width][width];
			for(j = 0; j < width; j++)
			{
				for(k = 0; k < width; k++)
				{
					num_arr[j][k] = scan.nextInt();
				}
			}
			for(j = 0; j < width; j++)
			{
				boolean check = false;
				for(k = 0; k < width; k++)
				{
					if(check == false && num_arr[k][j] == 1)
						check = true;
					else if(check == true && num_arr[k][j] == 2)
					{
						check = false;
						answer++;
					}
				}
			}
			System.out.println("#" + i + " " + answer);
		}
	}
}
