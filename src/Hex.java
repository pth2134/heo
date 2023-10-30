package 백준문제;

import java.io.*;
import java.util.*;

public class Hex {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = 352;
		br.readLine();
		br.readLine();
		for(int i =0; i<n; i++) {
			for (int j = 0; j < 7; j++) {
				br.readLine();
			}
			String address = br.readLine().substring(15, 23);
			int ad = Integer.parseInt(address, 16);
			int result = ad+m;
			bw.write(Integer.toHexString(result)+"\n");
		}
		br.readLine();
		br.readLine();
		br.readLine();
		bw.flush();
		
	}
}


