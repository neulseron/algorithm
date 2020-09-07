package programming.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_4366_정식이의은행업무 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		String two, three;
		StringBuilder sb;
		int answer = 0;
		int[] arr2;
		int[][] arr3;
		
		for(int tc = 1; tc <= T; tc++) {
			two = br.readLine();
			three = br.readLine();
			arr2 = new int[two.length()];
			arr3 = new int[three.length()][2];
			// 2진수에서 하나의 숫자만 바꿔서 가능한 모든 경우 담기
			for(int i = 0; i < two.length(); i++) {
				sb = new StringBuilder(two);
				if(sb.charAt(i) == '0') {
					sb.setCharAt(i, '1');
				}else {
					sb.setCharAt(i, '0');
				}
				arr2[i] = Integer.parseInt(sb.toString(), 2);
			}
			// 3진수에서 하나의 숫자만 바꿔서 가능한 모든 경우 담기
			for(int j = 0; j < three.length(); j++) {
				sb = new StringBuilder(three);
				for(int i = 0; i < 2; i++) {
					if(sb.charAt(j) == '0') {
						sb.setCharAt(j, '1');
					}else if(sb.charAt(j) == '1') {
						sb.setCharAt(j, '2');
					}else {
						sb.setCharAt(j, '0');
					}
					arr3[j][i] = Integer.parseInt(sb.toString(),3);
				}
			}
			// 같은 숫자 찾기
	 Find : for(int num : arr2) {
				for(int i = 0; i < arr3.length; i++) {
					for(int j = 0; j < 2; j++) {
						if(num == arr3[i][j]) {
							answer = num;
							break Find;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}