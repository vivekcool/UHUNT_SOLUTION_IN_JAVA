package uhunt_DP_and_Dynamic_Programming;

import java.util.Scanner;

public class TrainRoute {
	public static int[] LD, LI;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			LI = new int[n];

			int a[] = new int[n];
			LD = new int[a.length];

			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();

			}
			int ans = 0;
			if (n > 0) {
				LID(a);
				LIS(a);
			}
				for (int i = 0; i < n; i++) {
					// System.out.println(LI[i] + " " + LD[i]);
					ans = Math.max(ans, LI[i] + LD[i] - 1);
				}
				System.out.println(ans);
			

		}
	}

	public static void LIS(int[] a) {

		LI[0] = 1;

		for (int i = a.length - 1; i >= 0; i--) {
			LI[i] = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					LI[i] = Math.max(LI[i], LI[j] + 1);
				}
			}
		}

		return;
	}

	public static void LID(int[] a) {

		LD[0] = 1;
		for (int i = a.length - 1; i >= 0; i--) {
			LD[i] = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					LD[i] = Math.max(LD[i], LD[j] + 1);
				}
			}
		}

		return;
	}

}
