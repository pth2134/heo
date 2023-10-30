package 백준문제;

import java.io.*;
import java.util.*;

public class Distance_and_radius {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			double dd = Math.pow(x1-x2,2)+Math.pow(y1-y2,2); //거리제곱
			double distance = Math.sqrt(dd);//거리
			double rr = Math.pow(r1-r2, 2);
			
			if(distance==0&&r1==0&&r2==0) {
				//두 터렛과 마린이 한 점에 있음
				bw.write(1+"\n");
			} else if(distance==0&&r1==r2) {
				//겹침
				bw.write(-1+"\n");
			} else if(dd<rr) {
				//내부에 있음
				bw.write(0+"\n");
			} else if(dd == rr) {
				//내접
				bw.write(1+"\n");
			} else if(distance < r1+r2) {
				//2점에서 만남
				bw.write(2+"\n");
			} else if(distance == r1+r2) {
				//외접
				bw.write(1+"\n");
			} else{
				//만나지 않음
				bw.write(0+"\n");
			}
		}
		
		bw.flush();
	}
}
