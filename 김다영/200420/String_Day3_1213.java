import java.io.FileInputStream;
import java.util.Scanner;
public class String_Day3_1213 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1213.txt"));
		Scanner scan = new Scanner(System.in);
		int TC, answer, index;
		int j;
		String find, str;
		for(int i = 1; i <= 10; i++)
		{
			answer = 0;
			index = 0;
			TC = scan.nextInt();
			find = scan.next();
			str = scan.next();
			while(true)
			{
				if(index >= (str.length() - find.length() + 1))
					break;
				if(str.charAt(index) == find.charAt(0))
				{
					for(j = 1; j < find.length(); j++)
					{
						if(str.charAt(index + j) != find.charAt(j))
						{
							index += 1;
							break;
						}
					}
					if(j == find.length())
					{
						index += find.length();
						answer++;
					}
				}
				else
					index += 1;	
			}
			System.out.println("#" + i + " " + answer);
		}
	}
}
