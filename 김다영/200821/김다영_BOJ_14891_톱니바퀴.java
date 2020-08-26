package programming.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 1. 각 톱니바퀴에 대한 정보를 담은 ArrayList를 배열로 관리
 * 2. 회전을 진행할 때, 왼쪽과 오른쪽을 따로 체크
 * 3. 왼쪽으로 진행하면서 2번과 6번이 일치하는지 확인. 일치하면 그 위치(x)와 회전 방향 저장.
 * 4. 오른쪽으로 진행하면서 6번과 2번이 일치하는지 확인. 일치하면 그 위치(j)기억하고 break;
 * 5. x부터 j까지 돌면서 실제 회전 처리
 * 6. 0번째원소로 정답 계산
 */
public class 김다영_BOJ_14891_톱니바퀴 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int cnt, number, dir, answer = 0;
		// 톱니바퀴 정보
		ArrayList<Integer>[] gear = new ArrayList[4];
		for(int i = 0; i < 4; i++) {
			str = br.readLine();
			gear[i] = new ArrayList<Integer>();
			for(int j = 0; j < 8; j++) {
				gear[i].add(str.charAt(j) - '0');
			}
		}
		int j, tmpDir, x;
		// 회전 횟수
		cnt = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			number = Integer.parseInt(st.nextToken().trim());
			dir = Integer.parseInt(st.nextToken().trim());
			number -= 1; // 배열 index와 맞추기 위해
			tmpDir = dir;
			// 왼쪽 파악
			for(j = number-1; j >= 0; j--) {
				tmpDir *= -1; // 처음 시작 회전 방향 체크
				if(gear[j + 1].get(6) == gear[j].get(2)) { // 같은 극이면 break
					tmpDir *= -1;
					break;
				}
			}
			x = j + 1; // 처리해야 할 시작 위치 저장
			// 오른쪽 파악
			for(j = number+1; j < 4; j++) {
				if(gear[j-1].get(2) == gear[j].get(6)) // 같은 극이면 break
					break;
			}
			// 실제 회전
			for(int k = x; k < j; k++) {
				if(tmpDir == 1) {// 시계방향. 마지막 원소를 앞에 추가 후 마지막 원소 삭제
					gear[k].add(0, gear[k].get(7));
					gear[k].remove(8);
				}else { // 반시계방향
					gear[k].add(gear[k].get(0)); // 첫 원소를 추가 후 첫 원소 삭제
					gear[k].remove(0);
				}
				tmpDir *= -1; // 방향 전환
			}
		}
		// 0번째 원소로 값 계산
		for(int i = 0; i < 4; i++) {
			answer += gear[i].get(0)*Math.pow(2, i);
		}
		System.out.println(answer);
	}
}