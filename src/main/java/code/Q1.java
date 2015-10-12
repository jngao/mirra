package code;

/**
 * 对于一组排列完毕的数组，找出所给数值的起始和结束位置。算法时间复杂度为O(log n) 示例： 数组 [5, 7, 7, 8, 8, 10],数值 8,
 * 返回 [3, 4]
 * */
public class Q1 {

	private static int findLow(int[] arr, int from, int to, int n) {
		if (arr == null || from > to) {
			return -1;
		}
		int i = (from + to) / 2;

		if (arr[i] == n && (i == 0 || arr[i - 1] < n)) {
			return i;
		} else if (arr[i] < n) {
			return findLow(arr, i + 1, to, n);
		} else {
			return findLow(arr, from, i - 1, n);
		}
	}

	private static int findHigh(int[] arr, int from, int to, int n) {
		if (arr == null || from > to) {
			return -1;
		}
		int i = (from + to) / 2;

		if (arr[i] == n && (i == arr.length - 1 || arr[i + 1] > n)) {
			return i;
		} else if (arr[i] > n) {
			return findHigh(arr, from, i - 1, n);
		} else {
			return findHigh(arr, i + 1, to, n);
		}
	}

	private static void findStartEnd(int[] arr, int n) {
		if (arr == null) {
			return;
		}

		int low = findLow(arr, 0, arr.length - 1, n);
		int high = findHigh(arr, 0, arr.length - 1, n);

		System.out.println(low + ", " + high);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 7, 7, 8, 8, 8 };
		int n = 7;
		findStartEnd(arr, n);
	}
}
