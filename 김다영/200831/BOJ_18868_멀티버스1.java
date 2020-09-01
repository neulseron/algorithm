package programming.baekjoon.no18000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_18868_멀티버스1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 버퍼 생성
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력데이터를 공백으로 구분하기 위함
		int M = Integer.parseInt(st.nextToken().trim()); // M개의 반
		int N = Integer.parseInt(st.nextToken().trim()); // N명의 학생들
		int[][] rank = new int[M][N]; // 각 반의 학생들의 순위 저장
		ArrayList<Integer> input; // 입력 데이터 처리
		int tmp, idx, answer = 0; // 임시 변수와 그 index, 정답 쌍의 수 저장
		boolean flag = true; // 쌍을 이루는지 확인
		for(int i = 0; i < M; i++) { // M개의 반에 대한 정보 입력
			st = new StringTokenizer(br.readLine()); // 입력 정보 구분자로 구분
			input = new ArrayList<>(); // 입력 데이터를 위한 arraylist 생성
			for(int j = 0; j < N; j++) { // 학생수만큼 입력 받음
				input.add(Integer.parseInt(st.nextToken().trim()));
			}
			for(int j = 0; j < N; j++) { // 입력받은 데이터로 학생들 순위 저장
				tmp = Collections.min(input); // 최소값을 구하고
				idx = input.indexOf((Integer)tmp); // 최소값의 index를 구하기
				rank[i][idx] = j; // 최솟값의 index 위치에 순위 저장
				input.set(idx, Integer.MAX_VALUE); // 해당 학생의 입력데이터 Max로 초기화
			}
		}
		for(int i = 0; i < M-1; i++) { // M-1개의 반을 기준으로
			for(int j = i+1; j < M; j++) { // 자신 다음 반들과 비교 
				flag = true; // flag 초기화
				for(int k = 0; k < N; k++) { // N명의 학생들 성적 모두 비교
					if(rank[i][k] != rank[j][k]) { // i번째 반 k학생의 순위와 j번째 반 k학생 순위가 다르다면
						flag = false; // 쌍이 될 수 없음을 표시하고 break
						break;
					}
				}
				if(flag) answer++; // 쌍이 될 수 있다면 answer++
			}
		}
		System.out.println(answer); // 정답 출력
	}
}