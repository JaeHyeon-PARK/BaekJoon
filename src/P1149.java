import java.util.Scanner;

public class P1149 {
	static int[][] map;
	static int[][] DP;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][3];
		DP = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 0) map[i][j] = DP[i][j] = sc.nextInt();
				else map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 1; i < N; i++) {
			DP[i][0] = Math.min(DP[i - 1][1], DP[i - 1][2]) + map[i][0];
			DP[i][1] = Math.min(DP[i - 1][0], DP[i - 1][2]) + map[i][1];
			DP[i][2] = Math.min(DP[i - 1][0], DP[i - 1][1]) + map[i][2];
		}
		
		System.out.println(Math.min(Math.min(DP[N - 1][0], DP[N - 1][1]), DP[N - 1][2]));
	}
}