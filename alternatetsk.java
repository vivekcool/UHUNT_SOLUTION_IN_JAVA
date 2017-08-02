package uhunt_DP_and_Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Alternate_task {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {
		FastReader in = new FastReader();
		int n = in.nextInt();
		int a[] = new int[1001];
		Arrays.fill(a, -1);

		for (int i = 1; i <= 1000; i++) {
			int x = SumOfDivisors(i);
			if (x <= 1000)
				a[x] = i;
		}
		int cs = 1;
		while (n != 0) {
			System.out.println("Case " + (cs++) + ": " + a[n]);
			n=in.nextInt();

		}
	}

	public static int SumOfDivisors(int x) {
		if (x == 1)
			return 1;
		int i, ans = 1, sq = (int) Math.sqrt(x);
		for (i = 2; i <= sq; i++) {
			if (x % i == 0)
				if (i * i == x)
					ans += i;
				else
					ans += i + x / i;
		}
		return ans + x;
	}

}
