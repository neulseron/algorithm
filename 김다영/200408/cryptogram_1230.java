import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class cryptogram_1230 {

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_1230.txt"));
		
		Scanner scan = new Scanner(System.in);
		int length = 0, instruction_len = 0, x = 0, y = 0;
		String s;
		String tmp;
		char instruction;
		int j = 0, k = 0;
		for(int i = 1; i <= 10; i++)
		{
			length = scan.nextInt();
			ArrayList<String> arr = new ArrayList<String>();
			for(j = 0; j < length; j++
					)
			{
				tmp = scan.next();
				arr.add(tmp);
			}
			instruction_len = scan.nextInt();
			for(j = 0; j < instruction_len; j++)
			{
				instruction = scan.next().charAt(0);
				if(instruction == 'I')
				{
					x = scan.nextInt();
					y = scan.nextInt();
					for(k = 0; k < y; k++)
					{
						s = scan.next();
						arr.add(x, s);
						x += 1;
					}
				}
				else if(instruction == 'D')
				{
					x = scan.nextInt();
					y = scan.nextInt();
					for(k = 0; k < y; k++)
						arr.remove(x);
				}
				else if(instruction == 'A')
				{
					y = scan.nextInt();
					for(k = 0; k < y; k++)
					{
						s = scan.next();
						arr.add(s);
					}
				}
			}
			System.out.print("#" + i);
			for(j = 0; j < 10; j++)
			{
				System.out.print(" " + arr.get(j));
			}
			System.out.println("");
		}
	}
}
