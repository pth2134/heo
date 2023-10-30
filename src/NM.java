package 백준문제;


import java.io.*;
import java.util.*;

public class NM {
	static StringBuilder str = new StringBuilder();
	
	
	public static void rise(int n, int m, boolean[] check, int[] each) {
		if(m==0) {
			//출력(거꾸로 해야함) m부터 1까지 담고 0에서는 출력만함
			for(int i =each.length-1; i>=1; i--) {
				str.append(each[i]).append(" ");
			}
			str.append("\n");
		} else {
			//1부터 현재 있는 곳을 true로 설정 후 다음 자리 탐색
			for(int i =1; i<=n; i++) {
				if(!check[i]) {
					check[i] = true;
					each[m] = i;
					rise(n,m-1,check,each);
					check[i] =false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[n+1];
		int[] each = new int[m+1];
		rise(n,m,check,each);
		System.out.println(str);
	}
	
}
