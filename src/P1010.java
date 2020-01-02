import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010 {
	static int[][] DP;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		for(int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n == m) System.out.println(1);
			else {
				DP = new int[n + 1][m + 1];
				for(int i = 1; i <= m; i++) DP[1][i] = i;
				
				for(int i = 2; i <= n; i++) {
					for(int j = i; j <= m; j++) {
						for(int k = i - 1; k < j; k++)
							DP[i][j] += DP[i - 1][k];
					}
				}
				
				System.out.println(DP[n][m]);
			}
		}
	}
}