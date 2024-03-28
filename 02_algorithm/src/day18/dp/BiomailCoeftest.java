package day18.dp;

import java.util.Scanner;

public class BiomailCoeftest {

	public static void main(String[] args) { 
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		//int[][] B=new int[n+1][n+1];
		int[][] B=new int[n+1][k+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0,end=Math.min(i, k);j<=end;++j) {
				
				if(j==0 || j==i) B[i][j]=1;
				else B[i][j]=B[i-1][j-1]+B[i-1][j]; //점화식
			}
		}
		
		System.out.println(B[n][k]);
		
	}

}