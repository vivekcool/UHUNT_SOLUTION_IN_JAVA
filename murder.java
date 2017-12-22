
import java.util.Scanner;

public class Main {

	public static long sum = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			sum = 0;
			int n = in.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}

			int temp[] = new int[n];

			mergesort(a, temp, 0, n - 1);
			System.out.println(sum);

		}

	}

	public static void mergesort(int[] a, int[] temp, int i, int j) {
		if(i < j){
			int mid = (i + j) / 2;
			mergesort(a, temp, i, mid);
			mergesort(a, temp, mid + 1, j);
			merge(a, temp, i, mid, j);
		}

	}

	public static void merge(int[] a, int[] temp, int i, int mid, int j) {
		int st = i, end = mid + 1, k = i;
		//ystem.out.println(i+" "+mid+" "+j);

		while (st <= mid && end <= j) {
			if (a[st] < a[end]) {
				sum += (long) ((long) a[st] * (long) (j - end + 1));
				temp[k++] = a[st];
				st++;
			} else {
				temp[k++] = a[end];
				end++;
			}
		}

		while (st <= mid) {
			temp[k++] = a[st];
			st++;
		}

		while (end <= j) {
			temp[k++] = a[end];
			end++;
		}

		for (st = i; st <= j; st++) {
			a[st] = temp[st];
		}

	}

}
