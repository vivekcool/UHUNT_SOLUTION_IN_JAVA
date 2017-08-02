package uhunt_DP_and_Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class irreducible_form {
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
		FastReader in= new FastReader();
		int n=in.nextInt();
		while(n!=0) {
			System.out.println(Euler_Totient_Function(n));
			n=in.nextInt();
			
		}
		

	}

	public static long Euler_Totient_Function(int n) {
		double result = n; // Initialize result as n

		// Consider all prime factors of n and for every prime
		// factor p, multiply result with (1 - 1/p)
		for (int p = 2; p * p <= n; ++p) {
			// Check if p is a prime factor.
			if (n % p == 0) {
				// If yes, then update n and result
				while (n % p == 0)
					n /= p;
				result *= (1.0 - (1.0 / (float) p));
			}
		}

		// If n has a prime factor greater than sqrt(n)
		// (There can be at-most one such prime factor)
		if (n > 1)
			result *= (1.0 - (1.0 / (double) n));

		return (long) result;
	}

}
