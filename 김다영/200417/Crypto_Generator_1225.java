import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Crypto_Generator_1225 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1225.txt"));
		Scanner scan = new Scanner(System.in);
		
		int i, j, TC, cal, minus = 1;
		for(i = 1; i <= 10; i++)
		{
			TC = scan.nextInt();
			ArrayList<Integer> num_arr = new ArrayList<Integer>();
			minus = 1;
			for(j = 0; j < 8; j++)
				num_arr.add(scan.nextInt());
			while(true)
			{
				cal = num_arr.get(0) - minus;
				if(cal <= 0)
					cal = 0;
				num_arr.add(cal);
				num_arr.remove(0);
				if(cal==0)
					break;
				minus++;
				if(minus == 6)
					minus = 1;
			}
			System.out.print("#" + TC);
			for(j = 0; j < num_arr.size(); j++)
				System.out.print(" " + num_arr.get(j));
			System.out.println("");
		}
	}
}
