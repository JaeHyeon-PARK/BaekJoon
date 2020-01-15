import java.util.Scanner;

public class P1932 {
	static int[][] DP;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = 0;
		DP = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				DP[i][j] = sc.nextInt();
				if(i == 0 && j == 0) continue;
				else if(j == 0) DP[i][j] = DP[i - 1][j] + DP[i][j];
				else if(i == j) DP[i][j] = DP[i - 1][j - 1] + DP[i][j];
				else DP[i][j] = Math.max(DP[i - 1][j - 1], DP[i - 1][j]) + DP[i][j];
				
				if(res < DP[i][j]) res = DP[i][j];
			}			
		}
		System.out.println(res);
	}
}