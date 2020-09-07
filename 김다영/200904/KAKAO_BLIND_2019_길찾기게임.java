package programming.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
// 이진 탐색 트리 이용
public class KAKAO_BLIND_2019_길찾기게임 {

	static int nodeLen, cnt;
	static Tree[] BST;
	static int[][] answer, tree;
	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		int[][] result = solution(nodeinfo);
		System.out.println(Arrays.deepToString(result));
	}
	public static int[][] solution(int[][] nodeinfo) {
        nodeLen = nodeinfo.length;
		answer = new int[2][nodeLen];
        tree = new int[nodeLen][2]; // 복사한 배열 정렬
        BST = new Tree[nodeLen]; // 이진탐색트리
        Queue<Integer> q = new LinkedList<>();
        
        // 배열 정렬
        for(int i = 0; i < nodeLen; i++) {
        	tree[i][0] = nodeinfo[i][0];
        	tree[i][1] = nodeinfo[i][1];
        }
        Arrays.sort(tree, new Comparator<int[]>(){
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		if(o1[1] == o2[1])
        			return o1[0]-o2[0];
        		else
        			return o2[1]- o1[1];
        	}
        });
        
        // 이진 탐색 트리 구성
        for(int i = 0; i < nodeLen; i++)
        	q.offer(tree[i][0]);
        
        // 왼쪽, 오른쪽에 자식이 있으면 index로 넣고, 없으면 -1
        // parent : 현재 BST배열에 추가할 노드, left : 왼쪽 자식 index, right : 오른쪽 자식 index
        // index = tree배열의 index, Tidx : BST배열 index
        int parent, left, right, index = 1, Tidx = 0, i;
        while(!q.isEmpty()) {
        	parent = q.poll();
        	left = -1;
        	right = -1;
        	// 말단 노드가 아니라면
        	if(index < nodeLen) {
        		// 왼쪽인가
	        	left = index;
	        	if(tree[index][0] < parent) {
	        		// 위치할 수 있는가
	        		if(check(Tidx-1, tree[index][0], parent)) index++;
	        		else left = -1;
	        	}
	        	else left = -1;
	        	// 오른쪽인가
	        	if(index != nodeLen) {
		        	right = index;
		        	if(tree[index][0] > parent) {
		        		// 위치할 수 있는가
		        		if(check(Tidx-1, tree[index][0], parent)) index++;
		        		else right = -1;
		        	}
		        	else right = -1;
	        	}
        	}
        	// nodeinfo에서의 원래 위치 찾기
        	for(i = 0; i < nodeLen; i++) {
        		if(nodeinfo[i][0] == parent) break;
        	}
        	BST[Tidx++] = new Tree(parent, left, right, i+1);
        }
        cnt = 0;
        preOrder(0);
        cnt = 0;
        postOrder(0);
        return answer;
    }
	// 유효성 확인
	//Tidx : 지금까지 추가한 노드 수, cur : 현재 추가할지 고려하는 x좌표, parent : 부모로 고려중인 노드 x좌표
	private static boolean check(int Tidx, int cur, int parent) {
		for(int i = Tidx; i >= 0; i--) {
			if(BST[i].L != -1 && tree[BST[i].L][0] == parent) { // left
				if(cur < BST[i].x) {
					parent = BST[i].x;
				}else return false;
			}else if(BST[i].R != -1 && tree[BST[i].R][0] == parent) { // right
				if(cur > BST[i].x) {
					parent = BST[i].x;
				}else return false;
			}
		}
		return true;
	}
	// 전위 순회
	private static void preOrder(int idx) {
		answer[0][cnt++] = BST[idx].idx;
		int l = BST[idx].L;
		if(l != -1)
			preOrder(l);
		int r = BST[idx].R;
		if(r != -1)
			preOrder(r);
	}
	// 후위 순회
	private static void postOrder(int idx) {
		int l = BST[idx].L;
		if(l != -1)
			postOrder(l);
		int r = BST[idx].R;
		if(r != -1)
			postOrder(r);
		answer[1][cnt++] = BST[idx].idx;
	}
	static class Tree{
		int x, L, R, idx;
		public Tree(int x, int L, int R, int idx) {
			this.x = x;
			this.L = L;
			this.R = R;
			this.idx = idx;
		}
	}
}