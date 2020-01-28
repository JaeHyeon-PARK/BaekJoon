import java.util.Scanner;

public class P2156 {
	static int[] A;
	static int[] DP;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new int[N + 1];
		DP = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
			A[i] = sc.nextInt();
		if(N == 1) System.out.println(A[1]);
		else {
			DP[1] = A[1]; DP[2] = A[1] + A[2];
			for(int i = 3; i <= N; i++)
				DP[i] = Math.max(Math.max(DP[i - 1], A[i] + DP[i - 2]), A[i] + A[i - 1] + DP[i - 3]);
			System.out.println(DP[N]);
		}
	}
}