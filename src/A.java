import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A {
	static int[][][] graph;
	static boolean[][][] visit;
	static int n,m,h;
	static Queue<Integer[]> que = new LinkedList<>();
	static int[] x_move = {1,-1,0,0,0,0};
	static int[] y_move = {0,0,1,-1,0,0};
	static int[] z_move = {0,0,0,0,1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		graph = new int[n][m][h];
		visit = new boolean[n][m][h];
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					int input = Integer.parseInt(st.nextToken());
					graph[i][j][k] = input;
					if(graph[i][j][k]==1) {
						que.add(new Integer[]{i,j,k,0});
						visit[i][j][k] = true;
					}
				}
			}
		}
		int day = 0;
		while (!que.isEmpty()){
			Integer[] poll = que.poll();
			day = poll[3];
			for (int i = 0; i < 6; i++) {
				int y = poll[0]+y_move[i];
				int x = poll[1]+x_move[i];
				int z = poll[2]+z_move[i];
				if(y>=0&&y<n&&x>=0&&x<m&&z>=0&&z<h){
					if(!visit[y][x][z]){
						visit[y][x][z] = true;
						if(graph[y][x][z]==0){
							graph[y][x][z]=1;
							que.add(new Integer[]{y,x,z,day+1});
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < h; k++) {
					if(graph[i][j][k]==0){
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(day);
	}
}