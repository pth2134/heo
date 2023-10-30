package 백준문제;

import java.io.*;
import java.util.*;

public class Search {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //세로
		int m = Integer.parseInt(st.nextToken()); //가로
		int max = 0; 
		int cnt = 0; // 그림 갯수
		
		boolean[][] paper = new boolean[n][m];
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				paper[i][j] = st.nextToken().equals("1"); //1이면 true
			}
		}
		
		for(int i =0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(paper[i][j]) { //true 찾으면 좌,우,아래,위 탐색 후 
					cnt++;
					Searching s = new Searching(i, j, paper);
					s.parallel(i, j);
					s.vertical(i, j);
					if(s.area>max) max=s.area;
				}
			}
		}
		bw.write(cnt+"\n"+max);
		bw.flush();
		
	}

}
//true 찾으면 좌,우,아래,위 탐색 후 true인 쪽으로 갈라져서 계속 탐색하는 클래스
//true 를 만나면 false로 바꿔서 중복탐색이 없게끔
class Searching{
	int m,n;
	int area = 1; //첫 true를 갖고 출발함
	boolean[][] paper;
	
	public Searching(int i, int j,boolean[][] paper) {
		super();
		this.m = paper[0].length;
		this.n = paper.length;
		this.paper = paper;
		paper[i][j] = false; //탐색 시작 지점을 제외하고 탐색하기 때문에 
	}
	
	public void parallel(int v,int p) { //처음에 v에 i가, p에 j가 들어감
		left(v, p);
		right(v, p);
	}
	
	public void right(int v, int p) {
		if(p==this.m-1) return;
		if(this.paper[v][p+1]) {
			this.area +=1;
			this.paper[v][p+1] = false;
			right(v, p+1); //가던 방향 유지
			vertical(v, p+1);
		}
	}
	
	public void left(int v, int p) {
		if(p==0) return;
		if(this.paper[v][p-1]) {
			this.area +=1;
			this.paper[v][p-1] = false;
			left(v,p-1);
			vertical(v,p-1);
		}
	}
	
	public void vertical(int v, int p) { //상,하 탐색
		up(v,p);
		down(v,p);
	}
	
	public void up(int v, int p) { //왼쪽 위에서 시작 (v가 증가할수록 아래로 내려감)
		if(v==0) return;
		if(this.paper[v-1][p]) {
			this.area +=1;
			this.paper[v-1][p] = false;
			up(v-1, p);
			parallel(v-1, p);
		}
	}
	
	public void down(int v, int p) {
		if(v==this.n-1) return;
		if(this.paper[v+1][p]) {
			this.area +=1;
			this.paper[v+1][p] = false;
			down(v+1,p);
			parallel(v+1, p);
		}
	}
	
}
